package com.ss.openapi3.sample.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.ApiModelProperty;

public class FundsRegistration {
	
	@ApiModelProperty(notes = "Array of Fund Records")
	private List<Funds> fundsRecords;
	@ApiModelProperty(notes = "Fund Record and Id Mapping")
	private Map<String , Funds> fundsRecordsMap;
	
	private static FundsRegistration stdregd = null;
	
	private FundsRegistration(){
		fundsRecords = new ArrayList<Funds>();
		fundsRecordsMap = new HashMap<String, Funds>();
	}
	
	public static FundsRegistration getInstance() {
		
		if(stdregd == null) {
			stdregd = new FundsRegistration();
			return stdregd;
		}
		else {
			return stdregd;
		}
	}
	
	public void add(Funds std) {
		fundsRecords.add(std);
		fundsRecordsMap.put(std.getRegistrationNumber(), std);
	}
	
	public String upDatefunds(Funds std) {
		
		for(int i=0; i<fundsRecords.size(); i++)
        {
            Funds stdn = fundsRecords.get(i);
            System.out.println(stdn.getRegistrationNumber());
            System.out.println(std.getRegistrationNumber());
            if(stdn.getRegistrationNumber().equals(std.getRegistrationNumber())) {
            	fundsRecords.set(i, std);//update the new record
            	return "Update successful";
            }
        }
		
		return "Update un-successful";
		
	}
	
	public String deletefunds(String registrationNumber) {
		
		for(int i=0; i<fundsRecords.size(); i++)
        {
            Funds stdn = fundsRecords.get(i);
            if(stdn.getRegistrationNumber().equals(registrationNumber)) {
            	fundsRecords.remove(i);//update the new record
            	return "Delete successful";
            }
        }
		
		return "Delete un-successful";
		
	}

	public List<Funds> getfundsRecords() {
		return fundsRecords;
	}
	
	public Funds getfundsRecordsById(String regNum) {
		return fundsRecordsMap.get(regNum);
	}

}
