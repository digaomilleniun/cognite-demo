package br.com.rpires.TesteSDKCognite.demo.dto;

import com.cognite.client.dto.ExtractionPipeline;

public class ExtractionPipelineDTO {

    private Long id;

    private String externalID;

    private String name;

    private Long dataSetId;

    private String schedule;

    private Long createdTime;

    private Long lastUpdatedTime;

    private Long lastSuccess;

    private Long lastFailure;

    private Long lastSeen;

    private String createdBy;

    public ExtractionPipelineDTO(ExtractionPipeline val) {
        setId(val.getId());
        setExternalID(val.getExternalId());
        setName(val.getName());
        setDataSetId(val.getDataSetId());
        setSchedule(val.getSchedule());
        setCreatedTime(val.getCreatedTime());
        setLastUpdatedTime(val.getLastUpdatedTime());
        setLastSuccess(val.getLastSuccess());
        setLastFailure(val.getLastFailure());
        setLastSeen(val.getLastSeen());
        setCreatedBy(val.getCreatedBy());
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDataSetId() {
        return dataSetId;
    }

    public void setDataSetId(Long dataSetId) {
        this.dataSetId = dataSetId;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
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

    public Long getLastSuccess() {
        return lastSuccess;
    }

    public void setLastSuccess(Long lastSuccess) {
        this.lastSuccess = lastSuccess;
    }

    public Long getLastFailure() {
        return lastFailure;
    }

    public void setLastFailure(Long lastFailure) {
        this.lastFailure = lastFailure;
    }

    public Long getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(Long lastSeen) {
        this.lastSeen = lastSeen;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
