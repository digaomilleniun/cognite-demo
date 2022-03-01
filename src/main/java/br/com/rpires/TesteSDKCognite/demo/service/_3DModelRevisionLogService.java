package br.com.rpires.TesteSDKCognite.demo.service;

import br.com.rpires.TesteSDKCognite.demo.dto.Camera3DModelRevisionDTO;
import br.com.rpires.TesteSDKCognite.demo.dto._3DModelRevisionDTO;
import br.com.rpires.TesteSDKCognite.demo.dto._3DModelRevisionItemLogDTO;
import br.com.rpires.TesteSDKCognite.demo.dto._3DModelRevisionLogDTO;
import br.com.rpires.TesteSDKCognite.demo.exception.IntegrationException;
import com.cognite.client.CogniteClient;
import com.cognite.client.dto.ThreeDRevisionLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class _3DModelRevisionLogService {

    private CogniteClient client;

    @Autowired
    public _3DModelRevisionLogService(CogniteClient client) {
        this.client = client;
    }

    public List<_3DModelRevisionLogDTO> getLogs(Long modelId, Long revisionId) {
        try {
            List<ThreeDRevisionLog> list =
                    client.threeD()
                            .models()
                            .revisions()
                            .revisionLogs()
                            .retrieve(modelId, revisionId);
            return convertToDTO(list);
        } catch (Exception e) {
            throw new IntegrationException("ERROR LISTING ThreeDModelRevision ", e);
        }
    }

    private List<_3DModelRevisionLogDTO> convertToDTO(List<ThreeDRevisionLog> list) {
        List<_3DModelRevisionItemLogDTO> items = list.stream().map(log -> {
            return _3DModelRevisionItemLogDTO.builder()
                    .info(log.getInfo())
                    .severity(log.getSeverity())
                    .timestamp(log.getTimestamp())
                    .type(log.getType())
                    .build();
        }).collect(Collectors.toList());


        return List.of(_3DModelRevisionLogDTO.builder()
                .items(items)
                .build());
    }
}
