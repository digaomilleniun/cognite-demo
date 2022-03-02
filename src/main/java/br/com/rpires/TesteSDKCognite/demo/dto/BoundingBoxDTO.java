package br.com.rpires.TesteSDKCognite.demo.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoundingBoxDTO {

    private List<Double> max = null;

    private List<Double> min = null;
}
