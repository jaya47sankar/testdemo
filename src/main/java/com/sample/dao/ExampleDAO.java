package com.sample.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sample.model.Example;


public interface ExampleDAO extends CrudRepository<Example, Integer> {


	@SuppressWarnings("unchecked")
	public Example save(Example example);
	
	public Example findById(int id);
	
	public List<Example> findAll();
	
	@Query(value="select  id, name, address ,phone,created  from example  ORDER BY id",nativeQuery=true)
	public List<Example> getalldata();
	
	public Example findByPhone(String phone);
	
	public List<Example> findByIdLessThanEqual(int id);
	
	public List<Example> findByPhoneStartingWith(String phone);
	
	public void delete(Example example);
}
