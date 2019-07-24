package com.ss.openapi3.sample.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ss.openapi3.sample.beans.Funds;
import com.ss.openapi3.sample.beans.FundsRegistration;
import com.ss.openapi3.sample.beans.FundsRegResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@OpenAPIDefinition(
	    info = @Info(
	        title = "Client API",
	        version = "r0.4.0-2",
	        description = "The client-server API provides a simple lightweight API to let clients send messages, control rooms"
	            + " and synchronise conversation history. It is designed to support both lightweight clients which store no state"
	            + " and lazy-load data from the server as required - as well as heavyweight clients which maintain a full local"
	            + " persistent copy of server state.",
	        contact = @Contact(
	            name = "Anatoly Sablin",
	            email = "sablintolya@gmail.com"
	        ),
	        license = @License(
	            url = "http://www.apache.org/licenses/LICENSE-2.0.html",
	            name = "Apache 2.0"
	        )
	    ),
	    security = {
	        @SecurityRequirement(
	            name = "accessToken"
	        )
	    }
	)

@Controller
@Api(value="Funds Registration API", description="Add Funds to the Cache (POST)") 
public class FundsRegistrationController {
	
	@RequestMapping(method = RequestMethod.POST, value="/register/funds")	
	@ResponseBody
	@ApiOperation(value = "Adds a fund into the cache", response = FundsRegResponse.class)
	public FundsRegResponse registerStudent(@RequestBody Funds fund) {
		
		System.out.println("In Funds Addition");
        FundsRegResponse fundsRegResponse = new FundsRegResponse();           

        FundsRegistration.getInstance().add(fund);

        //We are setting the below value just to reply a message back to the caller
        fundsRegResponse.setFundName(fund.getName());
        fundsRegResponse.setAge(fund.getAge());
        fundsRegResponse.setfundsId(fund.getRegistrationNumber());
        fundsRegResponse.setfundStatus("Successful");


        return fundsRegResponse;
        
	}

}
