package br.com.rpires.TesteSDKCognite.demo.service;

import br.com.rpires.TesteSDKCognite.demo.exception.IntegrationException;
import com.cognite.client.CogniteClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Path;

@Service
public class _3DFileService {

    private CogniteClient client;

    @Autowired
    public _3DFileService(CogniteClient client) {
        this.client = client;
    }

    public void retrieve(Long threedFileId) {
        try {
            client.threeD()
                    .files()
                    .downloadToPath(threedFileId, Path.of("/tmp"));
        } catch (Exception e) {
            throw new IntegrationException("ERROR DOWNLOADING ThreeDFiles ", e);
        }
    }
}
