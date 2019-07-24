package com.ss.openapi3.sample.beans;

import io.swagger.annotations.ApiModelProperty;

public class FundsRegResponse {
	
	@ApiModelProperty(notes = "Name of the fund")
	String fundName;
	
	@ApiModelProperty(notes = "Age of the fund in the system")
	int age;
	
	@ApiModelProperty(notes = "ID of the fund")
	String fundsId;
	
	@ApiModelProperty(notes = "Status of the fund")
	String fundStatus;
	
	public String getfundName() {
		return fundName;
	}
	public void setFundName(String fundName) {
		this.fundName = fundName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getfundsId() {
		return fundsId;
	}
	public void setfundsId(String fundsId) {
		this.fundsId = fundsId;
	}
	public String getfundStatus() {
		return fundStatus;
	}
	public void setfundStatus(String fundStatus) {
		this.fundStatus = fundStatus;
	}	

}
