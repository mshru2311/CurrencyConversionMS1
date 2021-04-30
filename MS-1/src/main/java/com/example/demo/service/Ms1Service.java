package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.CoinsDTO;
import com.example.demo.entity.Coins;

public interface Ms1Service {

	Coins getConversionFactor(String code);

	Coins addConversionFactor(CoinsDTO coinsDto);

	Coins updateConversionFactor(CoinsDTO coins);

	CoinsDTO calculateConversionFactor(Coins c);

	List<Coins> getCurrencies();

}
