package com.example.demo.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CoinsDTO;
import com.example.demo.entity.Coins;
import com.example.demo.model.ConvertedAmount;
import com.example.demo.model.CurrentCurrency;
import com.example.demo.repository.Ms1Repository;

@Service
public class Ms1ServiceImpl implements Ms1Service {

	@Autowired
	Ms1Repository ms1Repo;
	
	@Autowired
	Ms2ServiceProxyInterface ms2Proxy;

	@Override
	public Coins getConversionFactor(String code) {
		return ms1Repo.findByCountCode(code);
	}

	@Override
	public Coins addConversionFactor(CoinsDTO coinsDto) {
		Coins coins=new Coins();
		BeanUtils.copyProperties(coinsDto, coins);
		coins=ms1Repo.save(coins);
		return coins;
	}

	@Override
	public Coins updateConversionFactor(CoinsDTO request) {
		Coins coins=new Coins();
		//CoinsDTO response=ms1Repo.findByCountCode(request.getCountCode());
		BeanUtils.copyProperties(ms1Repo.findByCountCode(request.getCountCode()), coins);
		if(coins!=null && coins.getCountCode()!=null) {
			coins.setConvFactor(request.getConvFactor());
			coins=ms1Repo.save(coins);
		}
			
		return coins;
	}

	@Override
	public CoinsDTO calculateConversionFactor(Coins c) {
		CurrentCurrency convCurr=new CurrentCurrency(c.getCountCode(),c.getConvFactor());
		return createCoinsDto(ms2Proxy.convertCurrency(convCurr));
	}
	
	public CoinsDTO createCoinsDto(ConvertedAmount convAmnt) {
		CoinsDTO coinsDto=new CoinsDTO();
		coinsDto.setConvFactor(convAmnt.getAmount());
		coinsDto.setCountCode(convAmnt.getCountCode());
		return coinsDto;
	}

	@Override
	public List<Coins> getCurrencies() {
		return ms1Repo.findAll();
	}
	
	
}
