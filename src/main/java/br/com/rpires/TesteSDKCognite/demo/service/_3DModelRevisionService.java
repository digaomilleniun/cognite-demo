package br.com.rpires.TesteSDKCognite.demo.service;

import br.com.rpires.TesteSDKCognite.demo.dto.*;
import br.com.rpires.TesteSDKCognite.demo.exception.IntegrationException;
import com.cognite.client.CogniteClient;
import com.cognite.client.Request;
import com.cognite.client.dto.ThreeDModel;
import com.cognite.client.dto.ThreeDModelRevision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class _3DModelRevisionService {

    private CogniteClient client;

    @Autowired
    public _3DModelRevisionService(CogniteClient client) {
        this.client = client;
    }

    public List<_3DModelRevisionDTO> getList(Long modelId) {
        try {
            List<ThreeDModelRevision> list = getThreeDModelRevisions(modelId, Request.create());
            return convertToDTO(list);
        } catch (Exception e) {
            throw new IntegrationException("ERROR LISTING ThreeDModelRevision ", e);
        }
    }

    public List<_3DModelRevisionDTO> retrieve(Long modelId, List<br.com.rpires.TesteSDKCognite.demo.dto.Item> items) {
        try {
            List<ThreeDModelRevision> list = client.threeD()
                    .models()
                    .revisions()
                    .retrieve(modelId, ConvertService.convertToCogniteItems(items));

            return convertToDTO(list);
        } catch (Exception e) {
            throw new IntegrationException("ERROR LISTING ThreeDModelRevision ", e);
        }
    }

    public List<_3DModelRevisionDTO> upsert(Long modelId, List<_3DModelRevisionDTO> items, Boolean isNew) {
        try {
            List<ThreeDModelRevision> list = client.threeD()
                    .models()
                    .revisions()
                    .upsert(modelId, convertToDomain(items, isNew));

            return convertToDTO(list);
        } catch (Exception e) {
            throw new IntegrationException("ERROR CREATING/UPDATING ThreeDModelRevision ", e);
        }
    }

    public List<_3DModelRevisionDTO> filter(Long modelId, _3DModelRevisionFilter filter) {
        try {
            List<ThreeDModelRevision> list =
                    getThreeDModelRevisions(modelId, Request.create()
                            .withRootParameter("published", filter.getPublished()));
            return convertToDTO(list);
        } catch (Exception e) {
            throw new IntegrationException("ERROR LISTING ThreeDModelRevision ", e);
        }
    }

    public List<br.com.rpires.TesteSDKCognite.demo.dto.Item> delete(List<Item> items) {
        try {
            List<com.cognite.client.dto.Item> cogniteItems =
                    ConvertService.convertToCogniteItems(items);
            List<com.cognite.client.dto.Item> list = client.threeD()
                    .models()
                    .delete(cogniteItems);
            return ConvertService.convertToDtoItems(list);
        } catch (Exception e) {
            throw new IntegrationException("ERROR DELETING ThreeDModelRevision ", e);
        }
    }

    public void updateRevisionThumbnail(Long modelId, Long revisionId, Long thumbnailId) {
        try {
            client.threeD()
                    .models()
                    .revisions()
                    .updateThumbnail(modelId, revisionId, thumbnailId);
        } catch (Exception e) {
            throw new IntegrationException("ERROR DELETING ThreeDModelRevision ", e);
        }
    }

    private List<ThreeDModelRevision> getThreeDModelRevisions(Long modelId, Request request) throws Exception {
        List<ThreeDModelRevision> list = new ArrayList<>();
        client.threeD()
                .models()
                .revisions()
                .list(modelId, request)
                .forEachRemaining(model -> list.addAll(model));
        return list;
    }

    private List<_3DModelRevisionDTO> convertToDTO(List<ThreeDModelRevision> list) {
        return list.stream().map(revision -> {
            return _3DModelRevisionDTO.builder()
                    .id(revision.getId())
                    .createdTime(revision.getCreatedTime())
                    .metaData(revision.getMetadataMap())
                    .assetMappingCount(revision.getAssetMappingCount())
                    .fileId(revision.getFileId())
                    .published(revision.getPublished())
                    .rotation(revision.getRotationList())
                    .status(revision.getStatus())
                    .thumbnailThreedFileId(revision.getThumbnailThreedFileId())
                    .thumbnailURL(revision.getThumbnailURL())
                    .camera(Camera3DModelRevisionDTO.builder()
                            .position(revision.getCamera().getPositionList())
                            .target(revision.getCamera().getTargetList())
                            .build())
                    .build();
        }).collect(Collectors.toList());
    }

    private List<ThreeDModelRevision> convertToDomain(List<_3DModelRevisionDTO> list, Boolean isNew) {
        List<ThreeDModelRevision> convertedList = new ArrayList<>();
        list.forEach(revision -> {
            Assert.notNull(revision.getFileId(), "File ID is required");
            if (!isNew) {
                Assert.notNull(revision.getId(), "Revision ID is required");
            }

            ThreeDModelRevision.Builder builder =  ThreeDModelRevision.newBuilder();
            builder.setFileId(revision.getFileId());
            if (revision.getId() != null) {
                builder.setId(revision.getId());
            }
            if (revision.getCreatedTime() != null) {
                builder.setCreatedTime(revision.getCreatedTime());
            }
            if (revision.getAssetMappingCount() != null) {
                builder.setAssetMappingCount(revision.getAssetMappingCount());
            }
            if (revision.getPublished() != null) {
                builder.setPublished(revision.getPublished());
            }
            if (revision.getStatus() != null) {
                builder.setStatus(revision.getStatus());
            }
            if (revision.getThumbnailThreedFileId() != null) {
                builder.setThumbnailThreedFileId(revision.getThumbnailThreedFileId());
            }
            if (revision.getThumbnailURL() != null) {
                builder.setThumbnailURL(revision.getThumbnailURL());
            }

            revision.getMetaData().forEach((k,v) -> builder.putMetadata(k,v));
            revision.getRotation().forEach(rot -> builder.addRotation(rot));
            revision.getCamera().getPosition().forEach(po -> {
                ThreeDModelRevision.Camera.newBuilder()
                        .addPosition(po);
            });
            revision.getCamera().getTarget().forEach(ta -> {
                ThreeDModelRevision.Camera.newBuilder()
                        .addTarget(ta);
            });
            convertedList.add(builder.build());

        });
        return convertedList;
    }

}
