package br.com.rpires.TesteSDKCognite.demo.service;

import br.com.rpires.TesteSDKCognite.demo.dto.AssetDTO;
import br.com.rpires.TesteSDKCognite.demo.dto.TimeSeriesDTO;
import com.cognite.client.CogniteClient;
import com.cognite.client.dto.Asset;
import com.cognite.client.dto.TimeseriesMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TimeSerieservice {

    private CogniteClient client;

    @Autowired
    public TimeSerieservice(CogniteClient client) {
        this.client = client;
    }

    public List<TimeSeriesDTO> getTimeSeries() throws Exception {

        List<TimeseriesMetadata> listAssetsResults = new ArrayList<>();

        client.timeseries()
                .list()
                .forEachRemaining(assetBatch -> listAssetsResults.addAll(assetBatch));

        List<TimeSeriesDTO> listDTO = listAssetsResults.stream().map(TimeSeriesDTO::new).collect(Collectors.toList());
        return listDTO;
    }

}
