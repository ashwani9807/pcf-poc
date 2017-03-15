package com.ashwani.poc.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashwani.poc.models.CredentialsSource;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "api")
public class FirstBootController {

    @ApiOperation(
            value = "POC for PCF",
            httpMethod = "GET"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK")})
	@RequestMapping(name="/hello")
	public String getWelcomeMessage() throws IOException
	{
    	String message = "DEFAULT";
    	try{
    		//Map<String, Object> extraCredentials = new CredentialsSource("SERVICE_INSTANCE").getExtraCredentials();
    		//System.out.println("Keys are "+extraCredentials.keySet());
    		//message = "Hello There V1!!!Name : "+extraCredentials.get("username") + " and Password is :" + extraCredentials.get("password");
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return message;
	}
    
    
}
