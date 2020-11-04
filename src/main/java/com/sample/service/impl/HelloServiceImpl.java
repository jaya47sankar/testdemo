package com.sample.service.impl;

import org.springframework.stereotype.Service;

import com.sample.model.HelloModel;
import com.sample.service.HelloService;


@Service
public class HelloServiceImpl implements HelloService{

	
	String message = "";
	@Override
	public String hello(String password) {
		// TODO Auto-generated method stub
		if(password.equals("1234"))
		{
			
		HelloModel hm = new HelloModel();
		message = hm.getMsg1()+hm.getMsg2()+hm.getMsg3(); 
		return message;
		
		}
		else
		{
			return "ERROR";
		}
		
	}

}
