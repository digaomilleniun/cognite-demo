package br.com.rpires.TesteSDKCognite.demo.service;

import br.com.rpires.TesteSDKCognite.demo.dto.AssetDTO;
import br.com.rpires.TesteSDKCognite.demo.exception.BadRequestException;
import com.cognite.client.CogniteClient;
import com.cognite.client.Request;
import com.cognite.client.dto.Asset;
import com.cognite.client.dto.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AssetService {

    private CogniteClient client;

    @Autowired
    public AssetService(CogniteClient client) {
        this.client = client;
    }

    public List<AssetDTO> getAssets() throws Exception {
        List<Asset> listAssetsResults = new ArrayList<>();
        client.assets()
                .list()
                .forEachRemaining(assetBatch -> listAssetsResults.addAll(assetBatch));

        List<AssetDTO> listDTO = listAssetsResults.stream().map(AssetDTO::new).collect(Collectors.toList());
        return listDTO;
    }

    public List<AssetDTO> getAssets(Long limit) throws Exception {
        Request request = Request.create().withRootParameter("limit", limit);
        List<Asset> listAssetsResults = new ArrayList<>();
        String app = client.getClientConfig().getAppIdentifier();
        String sdk = client.getClientConfig().getSdkIdentifier();
        String session = client.getClientConfig().getSessionIdentifier();

        Iterator<List<Asset>> it = client.assets().list(request);
        listAssetsResults.addAll(it.next());
        it = null;

        List<AssetDTO> listDTO = listAssetsResults.stream().map(AssetDTO::new).collect(Collectors.toList());
        return listDTO;
    }

    public AssetDTO getAssetsByParent(String id) throws Exception {

        Request request = Request.create()
                .withFilterParameter("parentIds", new Long[]{Long.parseLong(id)});
        List<Asset> listAssetsResults = new ArrayList<>();

        client.assets()
                .list(request)
                .forEachRemaining(assetBatch -> listAssetsResults.addAll(assetBatch));

        List<AssetDTO> listDTO = listAssetsResults.stream().map(AssetDTO::new).collect(Collectors.toList());
        return listDTO.get(0);
    }

    public AssetDTO getAssetsByName(String name) throws Exception {

        Request request = Request.create()
                .withFilterParameter("name", name);
        List<Asset> listAssetsResults = new ArrayList<>();

        client.assets()
                .list(request)
                .forEachRemaining(assetBatch -> listAssetsResults.addAll(assetBatch));

        List<AssetDTO> listDTO = listAssetsResults.stream().map(AssetDTO::new).collect(Collectors.toList());
        return listDTO.get(0);
    }

    public AssetDTO retriver(String id) throws Exception {
        Request request = Request.create().withFilterParameter("assetSubtreeIds",id);
        Item item = Item.newBuilder().build();

        List<Asset> listAssetsResults = client.assets()
                .retrieve(List.of(item));


        List<AssetDTO> listDTO = listAssetsResults.stream().map(AssetDTO::new).collect(Collectors.toList());
        return listDTO.get(0);
    }

    public AssetDTO create(AssetDTO assetDTO) {
        try {
            Asset asset = Asset.newBuilder()
                    .setName(assetDTO.getName())
                    .setDescription(assetDTO.getDescription())
                    .setExternalId(assetDTO.getExternalID())
                    .build();
            List<Asset> listAssetsResults = client.assets().upsert(List.of(asset));
            List<AssetDTO> listDTO = listAssetsResults.stream().map(AssetDTO::new).collect(Collectors.toList());
            return listDTO.get(0);
        } catch (Exception  e) {
            throw new BadRequestException(e.getMessage(), e);
        }

    }


}
