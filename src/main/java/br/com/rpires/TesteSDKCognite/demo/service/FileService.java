package br.com.rpires.TesteSDKCognite.demo.service;

import br.com.rpires.TesteSDKCognite.demo.dto.FileDTO;
import br.com.rpires.TesteSDKCognite.demo.dto.LabelDTO;
import br.com.rpires.TesteSDKCognite.demo.dto._3DModelDTO;
import br.com.rpires.TesteSDKCognite.demo.exception.IntegrationException;
import com.cognite.client.CogniteClient;
import com.cognite.client.dto.FileBinary;
import com.cognite.client.dto.FileContainer;
import com.cognite.client.dto.FileMetadata;
import com.google.protobuf.ByteString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileService {

    private CogniteClient client;

    @Autowired
    public FileService(CogniteClient client) {
        this.client = client;
    }

    public FileDTO upload(MultipartFile file) {
        try {
            List<FileMetadata> result = client.files()
                    .upload(List.of(createFile(file)));
            return convertToDTO(result.get(0));
        } catch (Exception e) {
            throw new IntegrationException("ERROR TRYING TO UPLOAD ", e);
        }
    }

    public List<FileDTO> getList() {
        try {
            List<FileDTO> list = new ArrayList<>();
            client.files()
                    .list().forEachRemaining(l -> list.addAll(convertToDTO(l)));
            return list;
        } catch (Exception e) {
            throw new IntegrationException("ERROR TRYING LIST FILES ", e);
        }
    }

    private List<FileDTO> convertToDTO(List<FileMetadata> list) {
        return list.stream().map(val -> convertToDTO(val)).collect(Collectors.toList());
    }

    private FileDTO convertToDTO(FileMetadata fileMetadata) {
        List<LabelDTO> labelList = new ArrayList<>();
        fileMetadata.getLabelsList().forEach(s -> {
            labelList.add(LabelDTO.builder().externalId(s).build());
        });

        return FileDTO.builder()
                .id(fileMetadata.getId())
                .name(fileMetadata.getName())
                .externalId(fileMetadata.getExternalId())
                .createdTime(fileMetadata.getCreatedTime())
                .lastUpdatedTime(fileMetadata.getLastUpdatedTime())
                .uploadedTime(fileMetadata.getUploadedTime())
                .sourceCreatedTime(fileMetadata.getSourceCreatedTime())
                .sourceModifiedTime(fileMetadata.getSourceModifiedTime())
                .dataSetId(fileMetadata.getDataSetId())
                .assetIds(fileMetadata.getAssetIdsList())
                .directory(fileMetadata.getDirectory())
                .metadata(fileMetadata.getMetadataMap())
                .mimeType(fileMetadata.getMimeType())
                .securityCategories(fileMetadata.getSecurityCategoriesList())
                .source(fileMetadata.getSource())
                .labels(labelList)
                .build();
    }

    private FileContainer createFile(MultipartFile file) throws IOException {
        FileMetadata.Builder fileMB = FileMetadata.newBuilder();
        fileMB.setUploaded(true);
        fileMB.setName(file.getName());
        fileMB.setSource("JDK-DEMO");

        return FileContainer.newBuilder()
                .setFileMetadata(fileMB.build())
                .setFileBinary(FileBinary.newBuilder()
                        .setBinary(ByteString.copyFrom(file.getBytes())))
                .build();
    }


}
