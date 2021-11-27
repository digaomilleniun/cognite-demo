package br.com.rpires.TesteSDKCognite.demo.controller;

import br.com.rpires.TesteSDKCognite.demo.dto.AssetDTO;
import br.com.rpires.TesteSDKCognite.demo.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("asset")
public class AssetController {

    @Autowired
    private AssetService cogniteService;

    @GetMapping
    public ResponseEntity<List<AssetDTO>> getAssets() throws Exception {
        return ResponseEntity.ok(cogniteService.getAssets());
    }

    @GetMapping("/limit/{limit}")
    public ResponseEntity<List<AssetDTO>> getAssetsWithLimit(@PathVariable Long limit) throws Exception {
        return ResponseEntity.ok(cogniteService.getAssets(limit));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssetDTO> retriver(@PathVariable String id) throws Exception {
        return ResponseEntity.ok(cogniteService.retriver(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<AssetDTO> getAssetsByName(@PathVariable String name) throws Exception {
        return ResponseEntity.ok(cogniteService.getAssetsByName(name));
    }

    @GetMapping("/parent/{id}")
    public ResponseEntity<AssetDTO> getAssets(@PathVariable String id) throws Exception {
        return ResponseEntity.ok(cogniteService.getAssetsByParent(id));
    }

    @PostMapping
    public ResponseEntity<AssetDTO> create(@RequestBody AssetDTO assetDTO) {
        return ResponseEntity.ok(cogniteService.create(assetDTO));
    }


    //@GetMapping(value = "teste")
    public List<String> getAssets1() throws Exception {
        return List.of("Rodrigo", "Pires");
    }

}
