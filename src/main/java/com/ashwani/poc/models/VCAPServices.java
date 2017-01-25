package com.ashwani.poc.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VCAPServices {

    private static final Logger LOG = LoggerFactory.getLogger(VCAPServices.class);

    @JsonProperty(value = "user-provided")
    List<UserProvidedService> userProvided;

    public UserProvidedService getUserProvidedService(String serviceName) {
        LOG.info("Resolving user-provided service " + serviceName + "...");
        return userProvided.stream()
                .filter(userProvidedService -> userProvidedService.getName().equals(serviceName))
                .findAny().get();
    }
    
    public List<String> getServiceNames()
    {
    	List<String> names = new ArrayList<>();
    	for(UserProvidedService service:userProvided)
    	{
    		names.add(service.getName());
    	}
    	
    	return names;
    }
}
