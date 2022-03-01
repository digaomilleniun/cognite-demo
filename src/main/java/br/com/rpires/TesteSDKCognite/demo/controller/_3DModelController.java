package br.com.rpires.TesteSDKCognite.demo.controller;

import br.com.rpires.TesteSDKCognite.demo.dto.*;
import br.com.rpires.TesteSDKCognite.demo.service._3DModelRevisionService;
import br.com.rpires.TesteSDKCognite.demo.service._3DModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("3dModel")
public class _3DModelController {

    @Autowired
    private _3DModelService modelService;

    @Autowired
    private _3DModelRevisionService revisionService;

    @GetMapping
    public ResponseEntity<List<_3DModelDTO>> get3DModels() throws Exception {
        return ResponseEntity.ok(modelService.getList());
    }

    @PostMapping(value = "/retrieve")
    public ResponseEntity<List<_3DModelDTO>> retrieve(@RequestBody List<Item> items) throws Exception {
        return ResponseEntity.ok(modelService.retrieve(items));
    }

    @PostMapping(value = "/filter")
    public ResponseEntity<List<_3DModelDTO>> filter(@RequestBody _3DModelFilter filter) throws Exception {
        return ResponseEntity.ok(modelService.filter(filter));
    }

    @PostMapping
    public ResponseEntity<List<_3DModelDTO>> create3DModels(@RequestBody List<_3DModelDTO> items) throws Exception {
        return ResponseEntity.ok(modelService.upsert(items));
    }

    @PutMapping
    public ResponseEntity<List<_3DModelDTO>> upsert3DModels(@RequestBody List<_3DModelDTO> items) throws Exception {
        return ResponseEntity.ok(modelService.upsert(items));
    }

    @DeleteMapping
    public ResponseEntity<List<Item>> delete3DModels(@RequestBody List<Item> items) throws Exception {
        return ResponseEntity.ok(modelService.delete(items));
    }

    /**
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
    public ResponseEntity<List<_3DModelRevisionDTO>> filter(@RequestBody _3DModelRevisionFilter filter) throws Exception {
        return ResponseEntity.ok(revisionService.filter(filter));
    }

    @PostMapping(value = "/{modelId}/revisions")
    public ResponseEntity<List<_3DModelRevisionDTO>> create3DRevisions(@PathVariable Long modelId,
                                                                          @RequestBody List<_3DModelRevisionDTO> items) throws Exception {
        return ResponseEntity.ok(revisionService.upsert(modelId, items));
    }**/
}
