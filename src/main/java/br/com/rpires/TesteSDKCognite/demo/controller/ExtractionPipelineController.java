package br.com.rpires.TesteSDKCognite.demo.controller;

import br.com.rpires.TesteSDKCognite.demo.dto.AssetDTO;
import br.com.rpires.TesteSDKCognite.demo.dto.ExtractionPipelineDTO;
import br.com.rpires.TesteSDKCognite.demo.service.ExtractionPipelineService;
import com.cognite.client.dto.ExtractionPipeline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("extractionPipeline")
public class ExtractionPipelineController {

    @Autowired
    private ExtractionPipelineService cogniteService;

    @GetMapping
    public ResponseEntity<List<ExtractionPipelineDTO>> getExtractionPipeline() throws Exception {
        return ResponseEntity.ok(cogniteService.getAll());
    }
}
