package br.com.rpires.TesteSDKCognite.demo.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Camera3DModelRevisionDTO {

    private List<Double> target;

    private List<Double> position;
}
