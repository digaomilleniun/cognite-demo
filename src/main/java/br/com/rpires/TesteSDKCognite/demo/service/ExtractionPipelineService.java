package br.com.rpires.TesteSDKCognite.demo.service;

import br.com.rpires.TesteSDKCognite.demo.dto.AssetDTO;
import br.com.rpires.TesteSDKCognite.demo.dto.ExtractionPipelineDTO;
import com.cognite.client.CogniteClient;
import com.cognite.client.dto.Asset;
import com.cognite.client.dto.ExtractionPipeline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExtractionPipelineService {

    private CogniteClient client;

    @Autowired
    public ExtractionPipelineService(CogniteClient client) {
        this.client = client;
    }

    public List<ExtractionPipelineDTO> getAll() throws Exception {
        List<ExtractionPipeline> listAssetsResults = new ArrayList<>();
        client.extractionPipelines()
                .list()
                .forEachRemaining(assetBatch -> listAssetsResults.addAll(assetBatch));

        List<ExtractionPipelineDTO> listDTO = listAssetsResults.stream().map(ExtractionPipelineDTO::new).collect(Collectors.toList());
        return listDTO;
    }
}
