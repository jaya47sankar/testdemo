package com.sample.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.dao.ExampleDAO;
import com.sample.model.Example;
import com.sample.model.HelloModel;
import com.sample.service.ExampleService;
import com.sample.service.HelloService;


@Service
public class ExampleServiceImpl implements ExampleService{
	
	@Autowired
	ExampleDAO dao;

	@Override
	public Example save(Example example) {
		// TODO Auto-generated method stub
		
		Example exm = dao.save(example);
		return exm;
	}

	@Override
	public Example findById(int id) {
		// TODO Auto-generated method stub
		Example exm = dao.findById(id);
		return exm;
	}

	@Override
	public List<Example> findAll() {
		// TODO Auto-generated method stub
		List<Example> exmlist = dao.findAll();
		return exmlist;
	}

	@Override
	public Example findByPhone(String phone) {
		// TODO Auto-generated method stub
		Example exm = dao.findByPhone(phone);
		return exm;
	}

	@Override
	public List<Example> getalldata() {
		// TODO Auto-generated method stub
		List<Example> exmlist = dao.getalldata();
		return exmlist;
	}

	@Override
	public List<Example> findByIdLessThan(int id) {
		// TODO Auto-generated method stub
		List<Example> exmlist = dao.findByIdLessThanEqual(id);
		return exmlist;
	}

	@Override
	public List<Example> findByPhoneStartingWith(String phone) {
		// TODO Auto-generated method stub
		List<Example> exmlist = dao.findByPhoneStartingWith(phone);
		return exmlist;
	}

	@Override
	public void delete(Example example) {
		// TODO Auto-generated method stub
		
		dao.delete(example);
		
	}


	


}
