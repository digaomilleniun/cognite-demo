package br.com.rpires.TesteSDKCognite.demo.service;

import br.com.rpires.TesteSDKCognite.demo.dto._3DModelDTO;
import br.com.rpires.TesteSDKCognite.demo.dto._3DModelFilter;
import br.com.rpires.TesteSDKCognite.demo.exception.IntegrationException;
import com.cognite.client.CogniteClient;
import com.cognite.client.Request;
import com.cognite.client.dto.Item;
import com.cognite.client.dto.ThreeDModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class _3DModelService {

    private CogniteClient client;

    @Autowired
    public _3DModelService(CogniteClient client) {
        this.client = client;
    }

    public List<_3DModelDTO> getList() {
        try {
            List<ThreeDModel> list = new ArrayList<>();
            client.threeD()
                    .models()
                    .list()
                    .forEachRemaining(model -> list.addAll(model));

            return convertToDTO(list);
        } catch (Exception e) {
            throw new IntegrationException("ERROR LISTING ThreeDModel ", e);
        }
    }

    public List<_3DModelDTO> retrieve(List<br.com.rpires.TesteSDKCognite.demo.dto.Item> items) {
        try {
            List<ThreeDModel> list = client.threeD()
                    .models()
                    .retrieve(convertToCogniteItems(items));
            return convertToDTO(list);
        } catch (Exception e) {
            throw new IntegrationException("ERROR LISTING ThreeDModel ", e);
        }
    }

    public List<_3DModelDTO> filter(_3DModelFilter filter) {
        try {
            Request request = createRequest(filter);

            List<ThreeDModel> list = new ArrayList<>();
            client.threeD()
                    .models()
                    .list(request)
                    .forEachRemaining(model -> list.addAll(model));

            return convertToDTO(list);
        } catch (Exception e) {
            throw new IntegrationException("ERROR LISTING ThreeDModel ", e);
        }
    }

    private Request createRequest(_3DModelFilter filter) {
        Request request = Request.create();
        if (filter.getPublished() != null) {
            request = request.withRootParameter("published", filter.getPublished());
        }
        return request;
    }

    public List<_3DModelDTO> upsert(List<_3DModelDTO> items) {
        try {

            List<ThreeDModel> list = client.threeD()
                    .models()
                    .upsert(convertToDomain(items));
            return convertToDTO(list);
        } catch (Exception e) {
            throw new IntegrationException("ERROR UPDATING OR INSERTING ThreeDModel ", e);
        }
    }

    public List<br.com.rpires.TesteSDKCognite.demo.dto.Item> delete(List<br.com.rpires.TesteSDKCognite.demo.dto.Item> items) {
        try {
            List<Item> cogniteItems = convertToCogniteItems(items);
            List<Item> list = client.threeD()
                    .models()
                    .delete(cogniteItems);
            return convertToDtoItems(list);
        } catch (Exception e) {
            throw new IntegrationException("ERROR DELETING ThreeDModel ", e);
        }
    }

    private List<Item> convertToCogniteItems(List<br.com.rpires.TesteSDKCognite.demo.dto.Item> items) {
        Assert.noNullElements(items, "List of items cannot be null.");
        return items.stream().map(i -> {
            if (i.getId() != null) {
                return Item.newBuilder().setId(i.getId()).build();
            } else {
                return Item.newBuilder().setExternalId(i.getExternalId()).build();
            }

        }).collect(Collectors.toList());
    }

    private List<br.com.rpires.TesteSDKCognite.demo.dto.Item> convertToDtoItems(List<Item> items) {
        return items.stream().map(i -> {
            return br.com.rpires.TesteSDKCognite.demo.dto.Item.builder().id(i.getId()).externalId(i.getExternalId()).build();
        }).collect(Collectors.toList());
    }

    private List<_3DModelDTO> convertToDTO(List<ThreeDModel> list) {
        return list.stream().map(_3DModelDTO::new).collect(Collectors.toList());
    }

    private List<ThreeDModel> convertToDomain(List<_3DModelDTO> list) {
        List<ThreeDModel> convertedList = new ArrayList<>();
        list.forEach(item -> {
            ThreeDModel.Builder builder = ThreeDModel.newBuilder();
            builder.setName(item.getName())
                    .setCreatedTime(item.getCreatedTime())
                    .setDataSetId(item.getDataSetId());
            item.getMetaData().forEach((k,v) -> builder.putMetadata(k,v));
            convertedList.add(builder.build());
        });
        return convertedList;
    }


}
