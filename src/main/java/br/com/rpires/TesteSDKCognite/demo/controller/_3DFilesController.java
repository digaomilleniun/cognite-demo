package br.com.rpires.TesteSDKCognite.demo.controller;

import br.com.rpires.TesteSDKCognite.demo.dto._3DModelRevisionDTO;
import br.com.rpires.TesteSDKCognite.demo.service._3DFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("3d/files")
public class _3DFilesController {

    @Autowired
    private _3DFileService revisionService;

    @GetMapping(value = "/{threedFileId}")
    public ResponseEntity<String> get3DModels(@PathVariable(required = true) Long threedFileId) throws Exception {
        revisionService.retrieve(threedFileId);
        return ResponseEntity.ok("DOWNLOADED IN TMP TEMP DIR");
    }
}
