package com.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.sample.service.HelloService;

@RestController
public class HelloController {
	
	@Autowired
	HelloService hs;
	
	String message="";
	
	
	
	@GetMapping("/hello")
	public String sayhello(@RequestParam("pass") String password)
	{
	
		message = hs.hello(password);
		return message;
	}

}
