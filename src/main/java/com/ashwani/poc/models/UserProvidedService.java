package com.ashwani.poc.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserProvidedService {

    @JsonProperty("name")
    String name;
    
    @JsonProperty("password")
    String password;

    @JsonProperty("label")
    String label;

    @JsonProperty("tags")
    List<String> tags;

    @JsonProperty("credentials")
    Map<String, Object> credentials;

    @JsonProperty("syslog_drain_url")
    String syslogDrainUrl;

    public String getName() {
        return name;
    }

    public String getLabel() {
        return label;
    }

    public String getPassword() {
		return password;
	}
    
    public List<String> getTags() {
        return tags;
    }

    public Map<String, Object> getCredentials() {
        return credentials;
    }

    public String getSyslogDrainUrl() {
        return syslogDrainUrl;
    }
}
