package com.ashwani.poc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstBootController {

	@RequestMapping(name="/")
	public String getWelcomeMessage()
	{
		return "Hello There!!!";
	}
}
