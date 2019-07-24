package com.ss.openapi3.sample.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "All details about the Funds. ")
public class Funds {
	
	
	@ApiModelProperty(notes = "Name of the fund")
	String name;
	@ApiModelProperty(notes = "Age of the fund in the system.")
	int age;
	@ApiModelProperty(notes = "Registration Number of the Fund.")
	String registrationNumber;
	//Name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
}
