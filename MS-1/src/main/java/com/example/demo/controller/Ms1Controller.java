package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CoinsDTO;
import com.example.demo.entity.Coins;
import com.example.demo.service.Ms1Service;

@RestController
@RequestMapping("/convert")
public class Ms1Controller {

	private static Logger log = LoggerFactory.getLogger(Ms1Controller.class);

	@Autowired
	Ms1Service ms1Service;
	
	@GetMapping("/get")
	public List<Coins> getCurrencies(){
		return ms1Service.getCurrencies();
	}

	@GetMapping("/get/{code}")
	public Double getConversionFactor(@PathVariable String code) {
		Coins c = ms1Service.getConversionFactor(code);
		if (c != null)
			return c.getConvFactor();
		else
			return 0.0;

	}

	@PostMapping("/add")
	public ResponseEntity<Coins> addConversionFactor(@RequestBody CoinsDTO coinsDto) {
		Coins c = ms1Service.addConversionFactor(coinsDto);
		if (c != null)
			return new ResponseEntity<Coins>(c, HttpStatus.FOUND);
		else
			return new ResponseEntity<Coins>(HttpStatus.NOT_FOUND);

	}

	@PutMapping("/update")
	public ResponseEntity<Coins> updateConversionFactor(@RequestBody CoinsDTO coins) {
		Coins c = ms1Service.updateConversionFactor(coins);
		if (c != null) {
			return new ResponseEntity<Coins>(c, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<Coins>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/get/converted/{code}")
	public ResponseEntity<Coins> calculateConversionFactor(@PathVariable String code) {
		Coins c = ms1Service.getConversionFactor(code);
		if (c != null) {
			CoinsDTO cdto = ms1Service.calculateConversionFactor(c);
			if (cdto != null)
				return new ResponseEntity<Coins>(c, HttpStatus.FOUND);
			else
				return new ResponseEntity<Coins>(HttpStatus.NOT_FOUND);
		} else
			return new ResponseEntity<Coins>(HttpStatus.NOT_FOUND);

	}

}
