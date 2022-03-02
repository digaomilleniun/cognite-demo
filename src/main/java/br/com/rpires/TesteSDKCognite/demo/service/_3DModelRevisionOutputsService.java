package br.com.rpires.TesteSDKCognite.demo.service;

import br.com.rpires.TesteSDKCognite.demo.dto._3DModelRevisionItemLogDTO;
import br.com.rpires.TesteSDKCognite.demo.dto._3DModelRevisionItemOutputsDTO;
import br.com.rpires.TesteSDKCognite.demo.dto._3DModelRevisionLogDTO;
import br.com.rpires.TesteSDKCognite.demo.dto._3DModelRevisionOutputsDTO;
import br.com.rpires.TesteSDKCognite.demo.exception.IntegrationException;
import com.cognite.client.CogniteClient;
import com.cognite.client.dto.ThreeDOutput;
import com.cognite.client.dto.ThreeDRevisionLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class _3DModelRevisionOutputsService {

    private CogniteClient client;

    @Autowired
    public _3DModelRevisionOutputsService(CogniteClient client) {
        this.client = client;
    }

    public List<_3DModelRevisionOutputsDTO> getOutputs(Long modelId, Long revisionId) {
        try {
            List<ThreeDOutput> list =
                    client.threeD()
                            .models()
                            .revisions()
                            .outputs()
                            .retrieve(modelId, revisionId);
            return convertToDTO(list);
        } catch (Exception e) {
            throw new IntegrationException("ERROR LISTING ThreeDModelRevision ", e);
        }
    }

    private List<_3DModelRevisionOutputsDTO> convertToDTO(List<ThreeDOutput> list) {
        List<_3DModelRevisionItemOutputsDTO> items = list.stream().map(output -> {
            return _3DModelRevisionItemOutputsDTO.builder()
                    .blobId(output.getBlobId())
                    .format(output.getFormat())
                    .version(output.getVersion())
                    .build();
        }).collect(Collectors.toList());


        return List.of(_3DModelRevisionOutputsDTO.builder()
                .items(items)
                .build());
    }
}
