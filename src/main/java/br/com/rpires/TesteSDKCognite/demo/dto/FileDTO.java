package br.com.rpires.TesteSDKCognite.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Builder
public class FileDTO {

    private Long id;

    private String externalId;

    private String name;

    private String directory;

    private String source;

    private String mimeType;

    private Map<String, String> metadata;

    private List<Long> assetIds = null;

    private Long dataSetId;

    private Long sourceCreatedTime;

    private Long sourceModifiedTime;

    private List<Long> securityCategories = null;

    private List<LabelDTO> labels = null;

    private GeoLocationDTO geoLocation;

    private Boolean uploaded;

    private Long uploadedTime;

    private Long createdTime;

    private Long lastUpdatedTime;

    private String uploadUrl;
}
