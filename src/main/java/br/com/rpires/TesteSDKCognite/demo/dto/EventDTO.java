package br.com.rpires.TesteSDKCognite.demo.dto;

import com.cognite.client.dto.Event;
import com.google.protobuf.Internal;

public class EventDTO {

    private Long id;

    private String externalId;

    private Long startTime;

    private Long endTime;

    private String description;

    private String type;

    private String subtype;

    private Integer assetIdsMemoizedSerializedSize;

    private Long createdTime;

    private Long lastUpdatedTime;

    private String source;

    public EventDTO(Event event) {
        setId(event.getId());
        setExternalId(event.getExternalId());
        setStartTime(event.getStartTime());
        setEndTime(event.getEndTime());
        setDescription(event.getDescription());
        setType(event.getType());
        setSubtype(event.getSubtype());
        setCreatedTime(event.getCreatedTime());
        setLastUpdatedTime(event.getLastUpdatedTime());
        setSource(event.getSource());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public Long getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(Long lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public Integer getAssetIdsMemoizedSerializedSize() {
        return assetIdsMemoizedSerializedSize;
    }

    public void setAssetIdsMemoizedSerializedSize(Integer assetIdsMemoizedSerializedSize) {
        this.assetIdsMemoizedSerializedSize = assetIdsMemoizedSerializedSize;
    }

    public Long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Long createdTime) {
        this.createdTime = createdTime;
    }
}
