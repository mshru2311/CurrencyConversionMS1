package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Coins;

public interface Ms1Repository extends JpaRepository<Coins, Long> {

	Coins findByCountCode(String code);

	
}
