package br.com.rpires.TesteSDKCognite.demo.dto;

import com.cognite.client.dto.Asset;

public class AssetDTO {

    private Long id;

    private String externalID;

    private Long parentId;

    private String name;

    private String description;

    public AssetDTO(Asset val) {
        setId(val.getId());
        setExternalID(val.getExternalId());
        setParentId(val.getParentId());
        setName(val.getName());
        setDescription(val.getDescription());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExternalID() {
        return externalID;
    }

    public void setExternalID(String externalID) {
        this.externalID = externalID;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
