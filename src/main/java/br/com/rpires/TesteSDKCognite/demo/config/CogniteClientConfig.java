package br.com.rpires.TesteSDKCognite.demo.config;

import com.cognite.client.CogniteClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CogniteClientConfig {

    @Bean
    public CogniteClient initCogniteClient() {
        return CogniteClient.ofKey("OWIyZWEwNjctMDFmNy00MjI0LWE5NDctYmRjMTcwYTU0Y2Jj")
                .withProject("publicdata");
    }
}
