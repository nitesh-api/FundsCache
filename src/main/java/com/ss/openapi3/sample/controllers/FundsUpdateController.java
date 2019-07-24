package com.ss.openapi3.sample.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ss.openapi3.sample.beans.Funds;
import com.ss.openapi3.sample.beans.FundsRegResponse;
import com.ss.openapi3.sample.beans.FundsRegistration;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(value="Funds Update API", description="Update exisiting Fund's details.") 
public class FundsUpdateController {
	
	@RequestMapping(method = RequestMethod.PUT, value="/update/fund")
	@ResponseBody
	@ApiOperation(value = "Updates a fund in the cache", response = String.class)
	public String updateFundDetails(@RequestBody Funds fund) {		
		System.out.println("In updateFundDetails");	   
	    return FundsRegistration.getInstance().upDatefunds(fund);		
	}	

}
