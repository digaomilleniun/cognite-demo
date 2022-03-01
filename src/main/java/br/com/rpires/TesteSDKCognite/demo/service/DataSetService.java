package br.com.rpires.TesteSDKCognite.demo.service;

import br.com.rpires.TesteSDKCognite.demo.dto.DataSetDTO;
import br.com.rpires.TesteSDKCognite.demo.dto._3DModelDTO;
import br.com.rpires.TesteSDKCognite.demo.exception.IntegrationException;
import com.cognite.client.CogniteClient;
import com.cognite.client.dto.DataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataSetService {

    private CogniteClient client;

    @Autowired
    public DataSetService(CogniteClient client) {
        this.client = client;
    }

    public List<DataSetDTO> getList() {
        try {
            List<DataSet> list = new ArrayList<>();
            client.datasets()
                    .list()
                    .forEachRemaining(model -> list.addAll(model));
            return convertToDTO(list);
        } catch (Exception e) {
            throw new IntegrationException("ERROR LISTING ThreeDModel ", e);
        }

    }

    private List<DataSetDTO> convertToDTO(List<DataSet> list) {
        return list.stream().map(data -> {
            return DataSetDTO.builder()
                    .id(data.getId())
                    .externalId(data.getExternalId())
                    .name(data.getName())
                    .description(data.getDescription())
                    .createdTime(data.getCreatedTime())
                    .lastUpdatedTime(data.getLastUpdatedTime())
                    .metaData(data.getMetadataMap())
                    .writeProtected(data.getWriteProtected())
                    .build();
        }).collect(Collectors.toList());
    }
}
