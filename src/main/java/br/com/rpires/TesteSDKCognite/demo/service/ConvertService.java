package br.com.rpires.TesteSDKCognite.demo.service;

import com.cognite.client.dto.Item;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class ConvertService {

    public static List<Item> convertToCogniteItems(List<br.com.rpires.TesteSDKCognite.demo.dto.Item> items) {
        Assert.noNullElements(items, "List of items cannot be null.");
        return items.stream().map(i -> {
            if (i.getId() != null) {
                return Item.newBuilder().setId(i.getId()).build();
            } else {
                return Item.newBuilder().setExternalId(i.getExternalId()).build();
            }

        }).collect(Collectors.toList());
    }

    public static List<br.com.rpires.TesteSDKCognite.demo.dto.Item> convertToDtoItems(List<Item> items) {
        Assert.noNullElements(items, "List of items cannot be null.");
        return items.stream().map(i -> {
            return br.com.rpires.TesteSDKCognite.demo.dto.Item.builder().id(i.getId()).externalId(i.getExternalId()).build();
        }).collect(Collectors.toList());
    }
}
