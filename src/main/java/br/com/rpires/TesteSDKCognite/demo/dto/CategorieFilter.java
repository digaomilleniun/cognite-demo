package br.com.rpires.TesteSDKCognite.demo.dto;

import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategorieFilter {

    private String name;
    private Map<String, List<String>> values;
}
