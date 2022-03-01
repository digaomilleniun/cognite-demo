package br.com.rpires.TesteSDKCognite.demo.dto;

import com.cognite.client.dto.ThreeDModel;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class _3DModelDTO {

    private Long id;
    private String name;
    private Long createdTime;
    private Long dataSetId;
    private Map<String, String> metaData;

    public _3DModelDTO(ThreeDModel model) {
        this.id = model.getId();
        this.name = model.getName();
        this.createdTime = model.getCreatedTime();
        this.dataSetId = model.getDataSetId();
        this.metaData = model.getMetadataMap();
    }


}
