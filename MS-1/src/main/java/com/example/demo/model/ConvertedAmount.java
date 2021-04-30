package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConvertedAmount {

	@Override
	public String toString() {
		return "ConvertedAmount [countCode=" + countCode + ", amount=" + amount + "]";
	}
	private String countCode;
	private double amount;
}
