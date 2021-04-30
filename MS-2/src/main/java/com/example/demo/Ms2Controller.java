package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency")
public class Ms2Controller {

	@PostMapping("/convCurrency")
	public ConvertedAmount convertCurrency(@RequestBody CurrentCurrency convCurr) {
		ConvertedAmount convAmount=new ConvertedAmount();
		convAmount.setAmount(convCurr.getAmount()*72);
		convAmount.setCountCode("USD");
		return convAmount;
	}
	
	@GetMapping("/get")
	public String getValue(){
		return "Service Working";
	}
}
