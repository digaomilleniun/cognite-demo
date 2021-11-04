package br.com.rpires.TesteSDKCognite.demo.service;

import br.com.rpires.TesteSDKCognite.demo.dto.AssetDTO;
import com.cognite.client.CogniteClient;
import com.cognite.client.dto.Asset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CogniteService {

    @Autowired
    private CogniteClient client;

    public List<AssetDTO> getAssets() throws Exception {

        List<Asset> listAssetsResults = new ArrayList<>();
        client.assets()
                .list()
                .forEachRemaining(assetBatch -> listAssetsResults.addAll(assetBatch));

        List<AssetDTO> listDTO = listAssetsResults.stream().map(AssetDTO::new).collect(Collectors.toList());
        return listDTO;
    }

}
