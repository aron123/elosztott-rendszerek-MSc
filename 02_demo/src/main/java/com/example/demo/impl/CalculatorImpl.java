package com.example.demo.impl;

import org.springframework.stereotype.Service;

import com.example.demo.Calculator;

@Service
public class CalculatorImpl implements Calculator {

	@Override
	public Double add(Double a, Double b) {
		return a + b;
	}

}
