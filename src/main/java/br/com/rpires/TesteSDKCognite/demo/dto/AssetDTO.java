package br.com.rpires.TesteSDKCognite.demo.dto;

import com.cognite.client.dto.Asset;

import java.util.Map;

public class AssetDTO {

    private Long id;

    private String externalID;

    private Long parentId;

    private Long rootId;

    private String name;

    private String description;

    private Long createdTime;

    private Long lastUpdatedTime;

    private Map<String, String> metadata;

    public AssetDTO() {

    }

    public AssetDTO(Asset val) {
        setId(val.getId());
        setExternalID(val.getExternalId());
        setParentId(val.getParentId());
        setRootId(val.getRootId());
        setName(val.getName());
        setDescription(val.getDescription());
        setCreatedTime(val.getCreatedTime());
        setLastUpdatedTime(val.getLastUpdatedTime());
        //setMetadata(val.getMetadataMap());

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

    public Long getRootId() {
        return rootId;
    }

    public void setRootId(Long rootId) {
        this.rootId = rootId;
    }

    public Long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Long createdTime) {
        this.createdTime = createdTime;
    }

    public Long getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(Long lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }
}
