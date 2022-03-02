package br.com.rpires.TesteSDKCognite.demo.controller;

import br.com.rpires.TesteSDKCognite.demo.dto.*;
import br.com.rpires.TesteSDKCognite.demo.service._3DModelRevisionLogService;
import br.com.rpires.TesteSDKCognite.demo.service._3DModelRevisionNodeService;
import br.com.rpires.TesteSDKCognite.demo.service._3DModelRevisionOutputsService;
import br.com.rpires.TesteSDKCognite.demo.service._3DModelRevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("3d/models")
public class _3DModelRevisionController {

    @Autowired
    private _3DModelRevisionService revisionService;

    @Autowired
    private _3DModelRevisionLogService revisionLogService;

    @Autowired
    private _3DModelRevisionOutputsService revisionOutputsLService;

    @Autowired
    private _3DModelRevisionNodeService revisionNodesLService;

    @GetMapping(value = "/{modelId}/revisions")
    public ResponseEntity<List<_3DModelRevisionDTO>> get3DModels(@PathVariable(required = true) Long modelId) throws Exception {
        return ResponseEntity.ok(revisionService.getList(modelId));
    }

    @PostMapping(value = "/{modelId}/revisions/retrieve")
    public ResponseEntity<List<_3DModelRevisionDTO>> retrieveRevisions(@PathVariable(required = true) Long modelId,
                                                                       @RequestBody List<Item> items) throws Exception {
        return ResponseEntity.ok(revisionService.retrieve(modelId, items));
    }

    @PostMapping(value = "/{modelId}/revisions/filter")
    public ResponseEntity<List<_3DModelRevisionDTO>> filter(@PathVariable(required = true) Long modelId,
                                                            @RequestBody _3DModelRevisionFilter filter) throws Exception {
        return ResponseEntity.ok(revisionService.filter(modelId, filter));
    }

    @PostMapping(value = "/{modelId}/revisions")
    public ResponseEntity<List<_3DModelRevisionDTO>> create3DRevisions(@PathVariable(required = true) Long modelId,
                                                                       @RequestBody List<_3DModelRevisionDTO> items) throws Exception {
        return ResponseEntity.ok(revisionService.upsert(modelId, items, true));
    }

    @PutMapping(value = "/{modelId}/revisions")
    public ResponseEntity<List<_3DModelRevisionDTO>> update3DRevisions(@PathVariable(required = true) Long modelId,
                                                                       @RequestBody List<_3DModelRevisionDTO> items) throws Exception {
        return ResponseEntity.ok(revisionService.upsert(modelId, items, false));
    }

    @DeleteMapping(value = "/{modelId}/revisions")
    public ResponseEntity<List<Item>> delete3DModelRevision(@RequestBody List<Item> items) throws Exception {
        return ResponseEntity.ok(revisionService.delete(items));
    }

    @GetMapping(value = "/{modelId}/revisions/{revisionId}/logs")
    public ResponseEntity<List<_3DModelRevisionLogDTO>> getLogs(@PathVariable(required = true) Long modelId,
                                                                @PathVariable(required = true) Long revisionId) throws Exception {
        return ResponseEntity.ok(revisionLogService.getLogs(modelId, revisionId));
    }

    @PutMapping(value = "/{modelId}/revisions/{revisionId}/thumbnail/{thumbnailFileId}")
    public ResponseEntity<String> updateRevisionThumbnail(@PathVariable(required = true) Long modelId,
                                                          @PathVariable(required = true) Long revisionId,
                                                          @PathVariable(required = true) Long thumbnailFileId) throws Exception {
        revisionService.updateRevisionThumbnail(modelId, revisionId, thumbnailFileId);
        return ResponseEntity.ok("Update thumbnail success");
    }

    @GetMapping(value = "/{modelId}/revisions/{revisionId}/outputs")
    public ResponseEntity<List<_3DModelRevisionOutputsDTO>> getOutputs(@PathVariable(required = true) Long modelId,
                                                                       @PathVariable(required = true) Long revisionId) throws Exception {
        return ResponseEntity.ok(revisionOutputsLService.getOutputs(modelId, revisionId));
    }

    @GetMapping(value = "/{modelId}/revisions/{revisionId}/nodes")
    public ResponseEntity<_3DModelRevisionNodeDTO> get3DNodes(@PathVariable(required = true) Long modelId,
                                                                       @PathVariable(required = true) Long revisionId) throws Exception {
        return ResponseEntity.ok(revisionNodesLService.getNodes(modelId, revisionId));
    }

    @PostMapping(value = "/{modelId}/revisions/{revisionId}/nodes/filter")
    public ResponseEntity<_3DModelRevisionNodeDTO> filter3DNodes(@PathVariable(required = true) Long modelId,
                                                              @PathVariable(required = true) Long revisionId,
                                                              @RequestBody _3DModelRevisionNodeFilter filter) throws Exception {
        return ResponseEntity.ok(revisionNodesLService.filterNodes(modelId, revisionId, filter));
    }

    @PostMapping(value = "/{modelId}/revisions/{revisionId}/nodes/byids")
    public ResponseEntity<_3DModelRevisionNodeDTO> filter3DNodes(@PathVariable(required = true) Long modelId,
                                                                 @PathVariable(required = true) Long revisionId,
                                                                 @RequestBody List<Item> items) throws Exception {
        return ResponseEntity.ok(revisionNodesLService.getNodesByIds(modelId, revisionId, items));
    }

    @GetMapping(value = "/{modelId}/revisions/{revisionId}/nodes/{nodeId}/ancestor")
    public ResponseEntity<_3DModelRevisionNodeDTO> get3DAncestorNodes(@PathVariable(required = true) Long modelId,
                                                              @PathVariable(required = true) Long revisionId,
                                                              @PathVariable(required = true) Long nodeId) throws Exception {
        return ResponseEntity.ok(revisionNodesLService.get3DAncestorNodes(modelId, revisionId, nodeId));
    }

}
