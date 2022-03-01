package br.com.rpires.TesteSDKCognite.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Item {

    private Long id;

    private String externalId;
}
