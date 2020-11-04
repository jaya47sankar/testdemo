package com.sample.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="EXAMPLE")
public class Example {
	
	
	@Id 
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "my_seq_gen")
	@SequenceGenerator(name = "my_seq_gen", sequenceName = "SEQ_EXAMPLE")
	private int id;
	
	private String name;
	private String address;
	private String phone;
	@JsonFormat(pattern="dd-MM-yyy")
	@Column(name = "created",insertable=false,updatable=false)
	private Date created;

	
	public Example() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

}
