package com.ss.openapi3.sample.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ss.openapi3.sample.beans.FundsRegistration;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.PathVariable;

@Controller
@Api(value="Funds Deletion API", description="Deletes Fund from cache") 
public class FundsDeleteController {
	
	@RequestMapping(method = RequestMethod.DELETE, value="/delete/funds/{fundsId}")
	@ResponseBody
	@ApiOperation(value = "Deletes a Fund from Cache", response = String.class)
	public String deleteStudentRecord(@PathVariable("fundsId") String fundsId) {		
		System.out.println("In deleteStudentRecord");	   
	    return FundsRegistration.getInstance().deletefunds(fundsId);		
	}	

}
