package com.spring.sigmaweb.backend.process.generic.dto;

import java.io.Serializable;


public class versionAppDTO implements Serializable {
    private String system;
    private String version;
    private String uri;

    public versionAppDTO(String system, String version, String uri) {
        super();
        this.system = system;
        this.version = version;
        this.uri = uri;
    }

    public String getSystem() {
        return system;
    }
    public void setsystem(String system) {
        this.system = system;
    }
    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }
    public String getUri() {
        return uri;
    }
    public void setUri(String uri) {
        this.uri = uri;
    }
    private static final long serialVersionUID = 1L;
}
