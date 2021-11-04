package br.com.rpires.TesteSDKCognite.demo.controller;

import br.com.rpires.TesteSDKCognite.demo.dto.AssetDTO;
import br.com.rpires.TesteSDKCognite.demo.service.CogniteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AssetController {

    @Autowired
    private CogniteService cogniteService;

    @GetMapping
    public List<AssetDTO> getAssets() throws Exception {
        return cogniteService.getAssets();
    }

    @GetMapping(value = "teste")
    public List<String> getAssets1() throws Exception {
        return List.of("Rodrigo", "Pires");
    }

}
