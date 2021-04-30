package com.example.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.ConvertedAmount;
import com.example.demo.model.CurrentCurrency;

@FeignClient(name="MS2",url="localhost:8082/currency")
public interface Ms2ServiceProxyInterface {

	@RequestMapping(value="/convCurrency", method=RequestMethod.POST)
	public ConvertedAmount convertCurrency(CurrentCurrency convCurr);
	
}
