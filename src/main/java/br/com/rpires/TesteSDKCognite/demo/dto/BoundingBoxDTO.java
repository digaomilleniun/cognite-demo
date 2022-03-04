package br.com.rpires.TesteSDKCognite.demo.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoundingBoxDTO {

    private List<Double> max = new ArrayList<>();

    private List<Double> min = new ArrayList<>();
}
