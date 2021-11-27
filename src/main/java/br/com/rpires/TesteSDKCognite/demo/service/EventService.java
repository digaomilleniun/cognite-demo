package br.com.rpires.TesteSDKCognite.demo.service;

import br.com.rpires.TesteSDKCognite.demo.dto.AssetDTO;
import br.com.rpires.TesteSDKCognite.demo.dto.EventDTO;
import com.cognite.client.CogniteClient;
import com.cognite.client.Request;
import com.cognite.client.dto.Asset;
import com.cognite.client.dto.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EventService {

    private CogniteClient client;

    @Autowired
    public EventService(CogniteClient client) {
        this.client = client;
    }

    public List<EventDTO> getEvents() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("limit",100);
//        Request request = Request.create().withFilterParameter("source", "fusion");
        Request request = Request.create().withRootParameter("limit",10);
        List<Event> listAssetsResults = new ArrayList<>();
        client.events()
                .list(request)
                .forEachRemaining(assetBatch -> listAssetsResults.addAll(assetBatch));

        List<EventDTO> listDTO = listAssetsResults.stream().map(EventDTO::new).collect(Collectors.toList());
        return listDTO;
    }
}
