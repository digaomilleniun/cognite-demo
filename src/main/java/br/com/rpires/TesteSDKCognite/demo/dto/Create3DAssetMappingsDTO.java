package br.com.rpires.TesteSDKCognite.demo.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Create3DAssetMappingsDTO {

    private List<Create3DAssetMappingsItemDTO> items;
}
