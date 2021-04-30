package com.example.demo.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CurrentCurrency implements Serializable {

	@Override
	public String toString() {
		return "CurrentCurrency [countCode=" + countCode + ", amount=" + amount + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -998817424055726279L;
	private String countCode;
	private double amount;
}
