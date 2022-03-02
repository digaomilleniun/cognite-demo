package br.com.rpires.TesteSDKCognite.demo.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class _3DAssetMappingsItemDTO {

    @NotNull
    private Long nodeId;

    @NotNull
    private Long assetId;

    private Long treeIndex;

    private Long subtreeSize;
}
