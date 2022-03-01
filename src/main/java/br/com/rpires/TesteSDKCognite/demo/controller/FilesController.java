package br.com.rpires.TesteSDKCognite.demo.controller;

import br.com.rpires.TesteSDKCognite.demo.dto.FileDTO;
import br.com.rpires.TesteSDKCognite.demo.dto.Item;
import br.com.rpires.TesteSDKCognite.demo.dto._3DModelRevisionDTO;
import br.com.rpires.TesteSDKCognite.demo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("files")
public class FilesController {

    @Autowired
    private FileService fileService;

    @GetMapping
    public ResponseEntity<List<FileDTO>> getList() throws Exception {
        return ResponseEntity.ok(fileService.getList());
    }

    @PostMapping
    public ResponseEntity<FileDTO> upload(@RequestParam("file") MultipartFile file) throws Exception {
        return ResponseEntity.ok(fileService.upload(file));
    }

}
