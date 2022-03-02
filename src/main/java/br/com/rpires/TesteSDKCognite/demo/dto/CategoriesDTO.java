package br.com.rpires.TesteSDKCognite.demo.dto;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoriesDTO {

    private String name;

    private Map<String, String> values;
}
