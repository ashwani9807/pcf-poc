package com.ashwani.poc.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashwani.poc.models.CredentialsSource;

@RestController
public class FirstBootController {

	@RequestMapping(name="/")
	public String getWelcomeMessage() throws IOException
	{
		Map<String, Object> extraCredentials = new CredentialsSource("SERVICE_INSTANCE").getExtraCredentials();
		System.out.println("Keys are "+extraCredentials.keySet());
		return "Hello There V1!!!"+extraCredentials.get("username");
	}
}
