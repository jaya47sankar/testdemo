package com.sample.response;

import java.util.List;

import com.sample.model.Example;

public class ExampleResponse {
	
	private Example example;
	private List<Example> examplelist;
	private String responsecode;
	private String responsemesage;
	public Example getExample() {
		return example;
	}
	public void setExample(Example example) {
		this.example = example;
	}
	public List<Example> getExamplelist() {
		return examplelist;
	}
	public void setExamplelist(List<Example> examplelist) {
		this.examplelist = examplelist;
	}
	public String getResponsecode() {
		return responsecode;
	}
	public void setResponsecode(String responsecode) {
		this.responsecode = responsecode;
	}
	public String getResponsemesage() {
		return responsemesage;
	}
	public void setResponsemesage(String responsemesage) {
		this.responsemesage = responsemesage;
	}
	
	
	

}
