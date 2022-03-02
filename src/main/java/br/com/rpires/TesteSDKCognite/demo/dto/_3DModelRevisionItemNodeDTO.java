package br.com.rpires.TesteSDKCognite.demo.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class _3DModelRevisionItemNodeDTO {

    private Long id;

    private Long treeIndex;

    private Long parentId;

    private Long depth;

    private String name;

    private Long subtreeSize;

    private PropertiesDTO properties;

    private BoundingBoxDTO boundingBox;
}
