package br.com.rpires.TesteSDKCognite.demo.config;

import com.cognite.client.CogniteClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.MalformedURLException;
import java.net.URL;

@Configuration
public class CogniteClientConfig {

    @Bean
    public CogniteClient initCogniteClient() throws MalformedURLException {
//        return CogniteClient.ofKey("OWIyZWEwNjctMDFmNy00MjI0LWE5NDctYmRjMTcwYTU0Y2Jj")
//                .withProject("publicdata");

//        return CogniteClient.ofKey("YWUwMzBmZWQtMGMzZS00M2U2LWI1NjMtNGVmMTFiMzkyNGM3")
//                .withProject("cognite");

        return CogniteClient.ofClientCredentials("43c6abf5-8aec-4648-941d-3af7552414ed",
                "zCz7Q~M7F91iIIS5BzwqJhBeaFA8~U~8QypOq",
                new URL("https://login.microsoftonline.com/b7484399-37aa-4c28-9a37-a32f24c0621f/oauth2/v2.0/token")
        ).withProject("sdkcognite").withBaseUrl("https://greenfield.cognitedata.com");
    }
}
