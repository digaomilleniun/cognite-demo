package br.com.rpires.TesteSDKCognite.demo.controller;

import br.com.rpires.TesteSDKCognite.demo.dto.Item;
import br.com.rpires.TesteSDKCognite.demo.dto._3DModelRevisionDTO;
import br.com.rpires.TesteSDKCognite.demo.dto._3DModelRevisionFilter;
import br.com.rpires.TesteSDKCognite.demo.dto._3DModelRevisionLogDTO;
import br.com.rpires.TesteSDKCognite.demo.service._3DModelRevisionLogService;
import br.com.rpires.TesteSDKCognite.demo.service._3DModelRevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("3dModel")
public class _3DModelRevisionController {

    @Autowired
    private _3DModelRevisionService revisionService;

    @Autowired
    private _3DModelRevisionLogService revisionLogService;

    @GetMapping(value = "/{modelId}/revisions")
    public ResponseEntity<List<_3DModelRevisionDTO>> get3DModels(@PathVariable Long modelId) throws Exception {
        return ResponseEntity.ok(revisionService.getList(modelId));
    }

    @PostMapping(value = "/{modelId}/revisions/retrieve")
    public ResponseEntity<List<_3DModelRevisionDTO>> retrieveRevisions(@PathVariable Long modelId,
                                                                       @RequestBody List<Item> items) throws Exception {
        return ResponseEntity.ok(revisionService.retrieve(modelId, items));
    }

    //TODO falta fazer
    @PostMapping(value = "/{modelId}/revisions/filter")
    public ResponseEntity<List<_3DModelRevisionDTO>> filter(@PathVariable Long modelId, @RequestBody _3DModelRevisionFilter filter) throws Exception {
        return ResponseEntity.ok(revisionService.filter(modelId, filter));
    }

    @PostMapping(value = "/{modelId}/revisions")
    public ResponseEntity<List<_3DModelRevisionDTO>> create3DRevisions(@PathVariable Long modelId,
                                                                       @RequestBody List<_3DModelRevisionDTO> items) throws Exception {
        return ResponseEntity.ok(revisionService.upsert(modelId, items, true));
    }

    @PutMapping(value = "/{modelId}/revisions")
    public ResponseEntity<List<_3DModelRevisionDTO>> update3DRevisions(@PathVariable Long modelId,
                                                                       @RequestBody List<_3DModelRevisionDTO> items) throws Exception {
        return ResponseEntity.ok(revisionService.upsert(modelId, items, false));
    }

    @DeleteMapping(value = "/{modelId}/revisions")
    public ResponseEntity<List<Item>> delete3DModelRevision(@RequestBody List<Item> items) throws Exception {
        return ResponseEntity.ok(revisionService.delete(items));
    }

    @GetMapping(value = "/{modelId}/revisions/{revisionId}/logs")
    public ResponseEntity<List<_3DModelRevisionLogDTO>> getLogs(@PathVariable Long modelId, @PathVariable Long revisionId) throws Exception {
        return ResponseEntity.ok(revisionLogService.getLogs(modelId, revisionId));
    }
}
