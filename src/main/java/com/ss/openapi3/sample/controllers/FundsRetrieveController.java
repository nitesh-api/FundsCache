package com.ss.openapi3.sample.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ss.openapi3.sample.beans.Funds;
import com.ss.openapi3.sample.beans.FundsRegResponse;
import com.ss.openapi3.sample.beans.FundsRegistration;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(value="Funds Retrieval API", description="Get Funds Details by Fund Id") 
public class FundsRetrieveController {
	
	@RequestMapping(method = RequestMethod.GET, value="/funds/allFunds")
	@ResponseBody
	@ApiOperation(value = "Get Funds from the cache", response = List.class)
	public List<Funds> getStudent() {
		return FundsRegistration.getInstance().getfundsRecords();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/funds/{fundId}")
	@ResponseBody
	public Funds getStudentById(@PathVariable("fundId") String regdNum) {
		return FundsRegistration.getInstance().getfundsRecordsById(regdNum);
	}

}
