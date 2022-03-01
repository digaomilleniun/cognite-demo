package br.com.rpires.TesteSDKCognite.demo.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
public class GeometryDTO {

    private String type;

    private List<Integer> coordinates = null;
}
