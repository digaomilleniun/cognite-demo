package br.com.rpires.TesteSDKCognite.demo.controller;

import br.com.rpires.TesteSDKCognite.demo.dto.DataSetDTO;
import br.com.rpires.TesteSDKCognite.demo.service.DataSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("dataSet")
public class DataSetController {

    @Autowired
    private DataSetService dataSetService;

    @GetMapping
    public ResponseEntity<List<DataSetDTO>> get3DModels() throws Exception {
        return ResponseEntity.ok(dataSetService.getList());
    }
}
