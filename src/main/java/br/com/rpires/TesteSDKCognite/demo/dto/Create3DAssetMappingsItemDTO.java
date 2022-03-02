package br.com.rpires.TesteSDKCognite.demo.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Create3DAssetMappingsItemDTO {

    @NotNull
    private Long nodeId;

    @NotNull
    private Long assetId;
}
