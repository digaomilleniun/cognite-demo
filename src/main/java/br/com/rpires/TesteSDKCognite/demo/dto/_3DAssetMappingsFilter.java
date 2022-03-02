package br.com.rpires.TesteSDKCognite.demo.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class _3DAssetMappingsFilter {

    private List<Long> assetIds;

    private List<Long> nodeIds;

    private List<Long> treeIndexes;
}
