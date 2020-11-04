package com.sample.service;

import java.util.List;

import com.sample.model.Example;

public interface ExampleService {
	

	public Example save(Example example);
	
	public Example findById(int id);
	
	public List<Example> findAll();
	
	public List<Example> getalldata();
	
	public Example findByPhone(String phone);
	
	public List<Example> findByIdLessThan(int id);
	
	public List<Example> findByPhoneStartingWith(String phone);
	
	public void delete(Example example);
}

