package com.phani.java;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value="/helloworld")
public class DemoController {
     
	@GetMapping(path="/health", produces= MediaType.TEXT_PLAIN_VALUE)
	public String getServiceStatus() {
		return "service running";
	}
	
	@GetMapping(path="/hi/{greetings}", produces= MediaType.TEXT_PLAIN_VALUE)
	public String sayHello(@PathVariable String greetings) {
		return "Hello  " + greetings;
	}
}
