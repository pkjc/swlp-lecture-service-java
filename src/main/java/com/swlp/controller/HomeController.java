package com.swlp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String apiUsageExamples(){
		return "<h1 style=\"text-align:center;margin-top:10vh;font-family:sans-serif;\">"
				+ "All api endpoints start with '/api' <hr>"
				+ "Currently, only the '/api/lectures' endpoint is supported. <br>";
	}
}
