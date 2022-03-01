package br.com.rpires.TesteSDKCognite.demo.service;


import br.com.rpires.TesteSDKCognite.demo.dto.LoginStatusDTO;
import com.cognite.client.CogniteClient;
import com.cognite.client.dto.LoginStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginService {

    private CogniteClient client;

    @Autowired
    public LoginService(CogniteClient client) {
        this.client = client;
    }

    public LoginStatusDTO getInfoLoggedUser() throws Exception {
//        LoginStatus login = this.client.loginStatusByApiKey();
//        return new LoginStatusDTO(login);

//        LoginStatus login = this.client.login().loginStatusByApiKey();
//        return new LoginStatusDTO(login);
        return null;
    }
}
