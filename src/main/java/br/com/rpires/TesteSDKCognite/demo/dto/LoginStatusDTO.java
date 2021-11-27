package br.com.rpires.TesteSDKCognite.demo.dto;

import com.cognite.client.dto.LoginStatus;

public class LoginStatusDTO {

    private String user;

    private Boolean loggedIn;

    private String project;

    private Long projectId;

    private Long apiKeyId;

    public LoginStatusDTO() {

    }

    public LoginStatusDTO(LoginStatus val) {
        setApiKeyId(val.getApiKeyId());
        setProject(val.getProject());
        setLoggedIn(val.getLoggedIn());
        setUser(val.getUser());
        setProjectId(val.getProjectId());
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Boolean getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(Boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getApiKeyId() {
        return apiKeyId;
    }

    public void setApiKeyId(Long apiKeyId) {
        this.apiKeyId = apiKeyId;
    }
}
