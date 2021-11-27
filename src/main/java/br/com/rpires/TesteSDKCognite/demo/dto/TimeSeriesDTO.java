package br.com.rpires.TesteSDKCognite.demo.dto;

import com.cognite.client.dto.TimeseriesMetadata;
import com.google.protobuf.Internal;
import com.google.protobuf.MapField;

import java.util.Map;

public class TimeSeriesDTO {

    private long id;

    private String externalId;

    private String name;

    private String description_;

    private boolean isString;

    private boolean isStep;

    private String unit;

    private long assetId;

    private int securityCategoriesMemoizedSerializedSize;

    private long createdTime;

    private long lastUpdatedTime;

    private Map<String, String> metadata;

    private long dataSetId;

    public TimeSeriesDTO(TimeseriesMetadata time) {
        setId(time.getId());
        setExternalId(time.getExternalId());
        setName(time.getName());
        setDescription_(time.getDescription());
        setString(time.getIsString());
        setStep(time.getIsStep());
        setUnit(time.getUnit());
        setAssetId(time.getAssetId());
        setCreatedTime(time.getCreatedTime());
        setLastUpdatedTime(time.getLastUpdatedTime());
        setMetadata(time.getMetadataMap());
        setDataSetId(time.getDataSetId());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription_() {
        return description_;
    }

    public void setDescription_(String description_) {
        this.description_ = description_;
    }

    public boolean isString() {
        return isString;
    }

    public void setString(boolean string) {
        isString = string;
    }

    public boolean isStep() {
        return isStep;
    }

    public void setStep(boolean step) {
        isStep = step;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public long getAssetId() {
        return assetId;
    }

    public void setAssetId(long assetId) {
        this.assetId = assetId;
    }

    public int getSecurityCategoriesMemoizedSerializedSize() {
        return securityCategoriesMemoizedSerializedSize;
    }

    public void setSecurityCategoriesMemoizedSerializedSize(int securityCategoriesMemoizedSerializedSize) {
        this.securityCategoriesMemoizedSerializedSize = securityCategoriesMemoizedSerializedSize;
    }

    public long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }

    public long getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(long lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    public long getDataSetId() {
        return dataSetId;
    }

    public void setDataSetId(long dataSetId) {
        this.dataSetId = dataSetId;
    }
}
