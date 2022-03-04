package br.com.rpires.TesteSDKCognite.demo.controller;

import br.com.rpires.TesteSDKCognite.demo.dto.*;
import br.com.rpires.TesteSDKCognite.demo.service._3DAssetMappingsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("3d/models")
public class _3DAssetMappingsController {

    @Autowired
    private _3DAssetMappingsService mappingsService;

    @Operation
    @GetMapping(value = "/{modelId}/revisions/{revisionId}/mappings")
    public ResponseEntity<_3DAssetMappingsDTO> getAssetMappings(@PathVariable(required = true) Long modelId,
                                                                @PathVariable(required = true) Long revisionId,
                                                                @RequestParam(required = false) Long nodeId,
                                                                @RequestParam(required = false) Long assetId,
                                                                @RequestParam(required = false) List<Double> min,
                                                                @RequestParam(required = false) List<Double> max) throws Exception {
        return ResponseEntity.ok(mappingsService.getAssetMappings(modelId, revisionId, nodeId, assetId, min, max));
    }

    @PostMapping(value = "/{modelId}/revisions/{revisionId}/mappings")
    public ResponseEntity<_3DAssetMappingsDTO> createAssetMappings(@PathVariable(required = true) Long modelId,
                                                                   @PathVariable(required = true) Long revisionId,
                                                                   @Valid @RequestBody(required = true) Create3DAssetMappingsDTO assetMappings) throws Exception {
        return ResponseEntity.ok(mappingsService.createAssetMappings(modelId, revisionId, assetMappings));
    }

    @DeleteMapping(value = "/{modelId}/revisions/{revisionId}/mappings")
    public ResponseEntity<Boolean> deleteAssetMappings(@PathVariable(required = true) Long modelId,
                                                                   @PathVariable(required = true) Long revisionId,
                                                                   @Valid @RequestBody(required = true) Create3DAssetMappingsDTO assetMappings) throws Exception {
        return ResponseEntity.ok(mappingsService.deleteAssetMappings(modelId, revisionId, assetMappings));
    }

    @PostMapping(value = "/{modelId}/revisions/{revisionId}/mappings/filter")
    public ResponseEntity<_3DAssetMappingsDTO> filterAssetMappings(@PathVariable(required = true) Long modelId,
                                                                   @PathVariable(required = true) Long revisionId,
                                                                   @Valid @RequestBody(required = true) _3DAssetMappingsFilter filter) throws Exception {
        return ResponseEntity.ok(mappingsService.filterAssetMappings(modelId, revisionId, filter));
    }
}
