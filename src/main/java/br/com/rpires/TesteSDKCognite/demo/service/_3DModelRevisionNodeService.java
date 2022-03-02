package br.com.rpires.TesteSDKCognite.demo.service;

import br.com.rpires.TesteSDKCognite.demo.dto.*;
import br.com.rpires.TesteSDKCognite.demo.exception.IntegrationException;
import com.cognite.client.CogniteClient;
import com.cognite.client.Request;
import com.cognite.client.ThreeDNodes;
import com.cognite.client.dto.ThreeDNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class _3DModelRevisionNodeService {

    private CogniteClient client;

    @Autowired
    public _3DModelRevisionNodeService(CogniteClient client) {
        this.client = client;
    }

    public _3DModelRevisionNodeDTO getNodes(Long modelId, Long revisionId) {
        try {
            List<ThreeDNode> list = new ArrayList<>();
            client.threeD()
                    .models()
                    .revisions()
                    .nodes()
                    .list(modelId, revisionId)
                    .forEachRemaining(n -> list.addAll(n));
            
            return convertToDTO(list);
        } catch (Exception e) {
            throw new IntegrationException("ERROR LISTING ThreeDNodes ", e);
        }
    }

    public _3DModelRevisionNodeDTO filterNodes(Long modelId, Long revisionId, _3DModelRevisionNodeFilter filter) {
        try {
            List<ThreeDNode> list = new ArrayList<>();
            Request request = Request.create()
                    .withFilterParameter("properties", createFilter(filter));
            client.threeD()
                    .models()
                    .revisions()
                    .nodes()
                    .filter(modelId, revisionId, request)
                    .forEachRemaining(n -> list.addAll(n));

            return convertToDTO(list);
        } catch (Exception e) {
            throw new IntegrationException("ERROR LISTING ThreeDNodes ", e);
        }
    }

    public _3DModelRevisionNodeDTO getNodesByIds(Long modelId, Long revisionId, List<Item> items) {
        try {
            List<ThreeDNode> list = client.threeD()
                    .models()
                    .revisions()
                    .nodes()
                    .retrieve(modelId, revisionId, ConvertService.convertToCogniteItems(items));

            return convertToDTO(list);
        } catch (Exception e) {
            throw new IntegrationException("ERROR LISTING ThreeDNodes ", e);
        }
    }

    public _3DModelRevisionNodeDTO get3DAncestorNodes(Long modelId, Long revisionId, Long nodeId) {
        try {
            List<ThreeDNode> list = new ArrayList<>();
            client.threeD()
                    .models()
                    .revisions()
                    .nodes()
                    .list(modelId, revisionId, nodeId)
                    .forEachRemaining(n -> list.addAll(n));

            return convertToDTO(list);
        } catch (Exception e) {
            throw new IntegrationException("ERROR LISTING ANCESTOR ThreeDNodes ", e);
        }
    }

    private ThreeDNode.PropertiesFilter createFilter(_3DModelRevisionNodeFilter filter) {
        ThreeDNode.PropertiesFilter.Builder propsBuilder = ThreeDNode.PropertiesFilter.newBuilder();
        ThreeDNode.PropertiesFilter.Categories.Builder catBuilder = ThreeDNode.PropertiesFilter.Categories.newBuilder();
        ThreeDNode.PropertiesFilter.Categories.CategoriesValues.Builder catValBuilder =
                ThreeDNode.PropertiesFilter.Categories.CategoriesValues.newBuilder();
        filter.getCategories().forEach(cat -> {
            cat.getValues().forEach((k,v) -> {
                v.forEach(val -> catValBuilder.addValuesString(val));
                catBuilder.putValues(k, catValBuilder.build());

            });
            catBuilder.setName(cat.getName());
            propsBuilder.addCategories(catBuilder.build());
        });
        return propsBuilder.build();
    }

    private _3DModelRevisionNodeDTO convertToDTO(List<ThreeDNode> list) {
        List<_3DModelRevisionItemNodeDTO> listDTO = list.stream().map(node -> {
            List<CategoriesDTO> cats = new ArrayList<>();
            node.getProperties().getCategoriesList().forEach(cat -> {
                cats.add(CategoriesDTO.builder()
                        .name(cat.getName())
                        .build());
            });
            return _3DModelRevisionItemNodeDTO.builder()
                    .id(node.getId())
                    .depth(node.getDepth())
                    .name(node.getName())
                    .parentId(node.getParentId())
                    .subtreeSize(node.getSubtreeSize())
                    .treeIndex(node.getTreeIndex())
                    .properties(PropertiesDTO.builder()
                            .categories(cats)
                            .build())
                    .boundingBox(
                            BoundingBoxDTO.builder()
                                    .max(node.getBoundingBox().getMaxList())
                                    .min(node.getBoundingBox().getMinList())
                                    .build()
                    )
                    .build();
        }).collect(Collectors.toList());

        return _3DModelRevisionNodeDTO.builder().items(listDTO).build();
    }



}
