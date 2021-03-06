package br.com.rpires.TesteSDKCognite.demo.controller;

import br.com.rpires.TesteSDKCognite.demo.dto.EventDTO;
import br.com.rpires.TesteSDKCognite.demo.service.AssetService;
import br.com.rpires.TesteSDKCognite.demo.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("event")
public class EventController {

    @Autowired
    private EventService cogniteService;

    @GetMapping
    public ResponseEntity<List<EventDTO>> getEvents() throws Exception {
        return ResponseEntity.ok(cogniteService.getEvents());
    }
}
