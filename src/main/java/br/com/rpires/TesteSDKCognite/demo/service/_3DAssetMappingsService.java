package br.com.rpires.TesteSDKCognite.demo.service;

import br.com.rpires.TesteSDKCognite.demo.dto.*;
import br.com.rpires.TesteSDKCognite.demo.exception.BadRequestException;
import br.com.rpires.TesteSDKCognite.demo.exception.IntegrationException;
import com.cognite.client.CogniteClient;
import com.cognite.client.Request;
import com.cognite.client.dto.ThreeDAssetMapping;
import com.cognite.client.dto.ThreeDNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class _3DAssetMappingsService {

    private CogniteClient client;

    @Autowired
    public _3DAssetMappingsService(CogniteClient client) {
        this.client = client;
    }

    public _3DAssetMappingsDTO getAssetMappings(Long modelId, Long revisionId, Long nodeId, Long assetId,
                                                List<Double> min, List<Double> max) {
        try {
            Request request = createRequest(nodeId, assetId, min, max);
            List<ThreeDAssetMapping> list = new ArrayList<>();
            client.threeD()
                    .models()
                    .revisions()
                    .assetMappings()
                    .list(modelId, revisionId, request)
                    .forEachRemaining(n -> list.addAll(n));

            return convertToDTO(list);
        } catch (Exception e) {
            throw new IntegrationException("ERROR LISTING ThreeDNodes ", e);
        }
    }

    private Request createRequest(Long nodeId, Long assetId, List<Double> min, List<Double> max) {
        Request request = Request.create();
        if (nodeId != null) {
            request = request.withRootParameter("nodeId", nodeId);
        }
        if (assetId != null) {
            request = request.withRootParameter("assetId", assetId);
        }
        if ((min != null && !min.isEmpty()) || (max != null && !max.isEmpty())) {
            ThreeDNode.BoundingBox.Builder builder = ThreeDNode.BoundingBox.newBuilder();
            if ((min != null && !min.isEmpty())) {
                min.forEach(m -> builder.addMin(m));
            }
            if ((max != null && !max.isEmpty())) {
                max.forEach(m -> builder.addMax(m));
            }
            request = request.withRootParameter("intersectsBoundingBox", builder.build());
        }
        return request;
    }

    public _3DAssetMappingsDTO createAssetMappings(Long modelId, Long revisionId, Create3DAssetMappingsDTO assetMappings) {
        try {
            List<ThreeDAssetMapping> list = client.threeD()
                    .models()
                    .revisions()
                    .assetMappings()
                    .create(modelId, revisionId, convertToDomain(assetMappings));
            return convertToDTO(list);
        } catch (Exception e) {
            throw new IntegrationException("ERROR CREATING ThreeDAssetMappings ", e);
        }
    }

    public Boolean deleteAssetMappings(Long modelId, Long revisionId, Create3DAssetMappingsDTO assetMappings) {
        try {
            return client.threeD()
                    .models()
                    .revisions()
                    .assetMappings()
                    .delete(modelId, revisionId, convertToDomain(assetMappings));
        } catch (Exception e) {
            throw new IntegrationException("ERROR CREATING ThreeDAssetMappings ", e);
        }
    }

    public _3DAssetMappingsDTO filterAssetMappings(Long modelId, Long revisionId, _3DAssetMappingsFilter filter) {
        try {
            List<ThreeDAssetMapping> list = new ArrayList<>();
            Request filterRequest = createFilterRequest(filter);
            client.threeD()
                    .models()
                    .revisions()
                    .assetMappings()
                    .filter(modelId, revisionId, filterRequest)
                    .forEachRemaining(n -> list.addAll(n));

            return convertToDTO(list);
        } catch (Exception e) {
            throw new IntegrationException("ERROR LISTING ThreeDNodes ", e);
        }
    }

    private Request createFilterRequest(_3DAssetMappingsFilter filter) {
        Request request = Request.create();
        if (!List.of(filter.getAssetIds()).isEmpty()) {
            return request.withFilterParameter("assetIds", filter.getAssetIds());
        }
        if (!List.of(filter.getNodeIds()).isEmpty()) {
            return request.withFilterParameter("nodeIds", filter.getNodeIds());
        }
        if (!List.of(filter.getTreeIndexes()).isEmpty()) {
            return request.withFilterParameter("treeIndexes", filter.getTreeIndexes());
        }

       throw new BadRequestException("You must pass at least one set of parameters");
    }

    private List<ThreeDAssetMapping> convertToDomain(Create3DAssetMappingsDTO assetMappings) {
        return assetMappings.getItems().stream().map(asset -> {
            return ThreeDAssetMapping.newBuilder()
                    .setAssetId(asset.getAssetId())
                    .setNodeId(asset.getNodeId())
                    .build();
        }).collect(Collectors.toList());
    }

    private _3DAssetMappingsDTO convertToDTO(List<ThreeDAssetMapping> list) {
        List<_3DAssetMappingsItemDTO> listDTO = list.stream().map(asset -> {

            return _3DAssetMappingsItemDTO.builder()
                    .nodeId(asset.getNodeId())
                    .assetId(asset.getAssetId())
                    .subtreeSize(asset.getSubtreeSize())
                    .treeIndex(asset.getTreeIndex())
                    .build();
        }).collect(Collectors.toList());

        return _3DAssetMappingsDTO.builder().items(listDTO).build();
    }



}
