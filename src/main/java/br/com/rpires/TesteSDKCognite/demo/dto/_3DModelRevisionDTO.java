package br.com.rpires.TesteSDKCognite.demo.dto;

import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class _3DModelRevisionDTO {

    private Long id;
    private Long fileId;
    private Boolean published;
    private List<Double> rotation;
    private Camera3DModelRevisionDTO camera;
    private String status;
    private Map<String, String> metaData;
    private Long thumbnailThreedFileId;
    private String thumbnailURL;
    private Long assetMappingCount;
    private Long createdTime;
}
