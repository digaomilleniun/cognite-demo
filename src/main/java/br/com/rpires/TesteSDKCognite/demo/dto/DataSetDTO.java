package br.com.rpires.TesteSDKCognite.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@Builder
public class DataSetDTO {

    private Long id;
    private String externalId;
    private String name;
    private String description;
    private Long createdTime;
    private Long lastUpdatedTime;
    private Map<String, String> metaData;
    private Boolean writeProtected;
}
