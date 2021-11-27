package br.com.rpires.TesteSDKCognite.demo.controller;

import br.com.rpires.TesteSDKCognite.demo.dto.EventDTO;
import br.com.rpires.TesteSDKCognite.demo.dto.TimeSeriesDTO;
import br.com.rpires.TesteSDKCognite.demo.service.EventService;
import br.com.rpires.TesteSDKCognite.demo.service.TimeSerieservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("timeSeries")
public class TimeSeriesController {

    @Autowired
    private TimeSerieservice cogniteService;

    @GetMapping
    public ResponseEntity<List<TimeSeriesDTO>> getEvents() throws Exception {
        return ResponseEntity.ok(cogniteService.getTimeSeries());
    }
}
