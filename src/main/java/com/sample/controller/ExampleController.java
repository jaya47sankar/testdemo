package com.sample.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.util.concurrent.Service;
import com.sample.model.Example;
import com.sample.response.ExampleResponse;
import com.sample.service.ExampleService;

@RestController
public class ExampleController {
	
	@Autowired
	ExampleService service;
	
	
	@PostMapping("/saveexample")
	public ExampleResponse saveexample(@RequestBody String body)
	{
		String request = body;
		System.out.println(request);
		ExampleResponse response = new ExampleResponse();
		
		try
		{
			ObjectMapper mapper = new ObjectMapper();
			Example example = mapper.readValue(body, Example.class);
			Example exmple = service.findByPhone(example.getPhone());
			
			if(exmple==null)
			{
				Example exm = service.save(example);
				
				response.setExample(exm);
				response.setResponsecode("200");
				response.setResponsemesage("SAVED");
			}
			else
			{
				response.setResponsecode("404");
				response.setResponsemesage("CANT SAVE DATA . DATA EXIST");
			}
			
			
			
		}
		
		catch (Exception e) {
			// TODO: handle exception
			response.setResponsecode("404");
			response.setResponsemesage("ERROR "+e);
		}
		
	
		return response;
	}
	
	
	@GetMapping("/getallexample")
	public ExampleResponse getexample()
	{
		
		ExampleResponse response = new ExampleResponse();
		List<Example> examplelist =  service.findAll();
		
		if(examplelist.isEmpty())
		{
			response.setExamplelist(examplelist);
			response.setResponsecode("404");
			response.setResponsemesage("NO DATA FOUND");
		}
		else
		{
			response.setExamplelist(examplelist);
			response.setResponsecode("200");
			response.setResponsemesage("SUCCESS");
		}
	
		return response;
	}
	
	@GetMapping("/getallexample1")
	public ExampleResponse getexample1()
	{
		
		ExampleResponse response = new ExampleResponse();
		List<Example> examplelist =  service.getalldata();
		
		if(examplelist.isEmpty())
		{
			response.setExamplelist(examplelist);
			response.setResponsecode("404");
			response.setResponsemesage("NO DATA FOUND");
		}
		else
		{
			response.setExamplelist(examplelist);
			response.setResponsecode("200");
			response.setResponsemesage("SUCCESS");
		}
	
		return response;
	}
	
	
	
	
	@GetMapping("/getexamplebyphone")
	public ExampleResponse getexamplebyphone(@RequestParam("phone") String phone)
	{
		
		ExampleResponse response = new ExampleResponse();
		Example example =  service.findByPhone(phone);
		
		try
		{
			String phoneno  = example.getPhone();
		
			response.setExample(example);
			response.setResponsecode("200");
			response.setResponsemesage("SUCCESS "+phone);
			
		}
		catch(Exception ex)
		{
			response.setResponsecode("404");
			response.setResponsemesage("NO DATA FOUND");
		}
	
		return response;
	}
	@GetMapping("/getalllessthan")
	public ExampleResponse getalllessthan(@RequestParam("id") String id)
	{
		
		ExampleResponse response = new ExampleResponse();
		List<Example> examplelist =  service.findByIdLessThan(Integer.parseInt(id));
		
		if(examplelist.size()>0)
		{
		
			response.setExamplelist(examplelist);;
			response.setResponsecode("200");
			response.setResponsemesage("SUCCESS ");
			
		}
		else
		{
			response.setResponsecode("404");
			response.setResponsemesage("NO DATA FOUND");
		}
	
		return response;
	}
	
	
	@GetMapping("/getbyphonenostartwith")
	public ExampleResponse getbyphonenostartwith(@RequestParam("phone") String phone)
	{
		
		ExampleResponse response = new ExampleResponse();
		List<Example> examplelist =  service.findByPhoneStartingWith(phone);
		
		if(examplelist.size()>0)
		{
		
			response.setExamplelist(examplelist);;
			response.setResponsecode("200");
			response.setResponsemesage("SUCCESS ");
			
		}
		else
		{
			response.setResponsecode("404");
			response.setResponsemesage("NO DATA FOUND");
		}
	
		return response;
	}
	
	
	@SuppressWarnings("unused")
	@PutMapping("/updateexample/{id}")
	public ExampleResponse updateexample(@PathVariable(value = "id") String id,
            @Valid @RequestBody String body)
	{
		String request = body;
		System.out.println(request);
		ExampleResponse response = new ExampleResponse();
		
		try
		{
			ObjectMapper mapper = new ObjectMapper();
			Example example = mapper.readValue(body, Example.class);
			Example exmple = service.findById(Integer.parseInt(id));
			
			exmple.setName(example.getName());
			
			if(exmple==null)
			{
				response.setResponsecode("404");
				response.setResponsemesage("NO SUCH DATA");
			}
			else
			{
				Example exm = service.save(exmple);
				
				response.setExample(exm);
				response.setResponsecode("200");
				response.setResponsemesage("DATA UPDATES. DATA EXIST");
			}
			
			
			
		}
		
		catch (Exception e) {
			// TODO: handle exception
			response.setResponsecode("404");
			response.setResponsemesage("ERROR "+e);
		}
		
	
		return response;
	}
	
	
	@DeleteMapping("/deleteexample/{id}")
	public ExampleResponse deleteexample(@PathVariable(value = "id") String id)
	{
		
		ExampleResponse response = new ExampleResponse();
		
		try
		{
		
			Example exmple = service.findById(Integer.parseInt(id));
			
			
			if(exmple==null)
			{
				response.setResponsecode("404");
				response.setResponsemesage("NO SUCH DATA");
			}
			else
			{
			    service.delete(exmple);
				
				response.setResponsecode("200");
				response.setResponsemesage("DATA DELETED");
			}
			
			
			
		}
		
		catch (Exception e) {
			// TODO: handle exception
			response.setResponsecode("404");
			response.setResponsemesage("ERROR "+e);
		}
		
	
		return response;
	}

}
