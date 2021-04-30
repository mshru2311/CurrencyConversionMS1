package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Currency")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Coins {

	@Id
	@GeneratedValue
	private Long id;
	private String countCode;
	private Double convFactor;

	@Override
	public String toString() {
		return "Coins [id=" + id + ", countCode=" + countCode + ", convFactor=" + convFactor + "]";
	}
}
