package br.com.rpires.TesteSDKCognite.demo.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PropertiesDTO {

    private List<CategoriesDTO> categories;
}
