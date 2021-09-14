package com.example.demo;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MainController {

	private final Calculator calculator;

	@RequestMapping("/")
	String main() {
		return "hello world";
	}
	
	@RequestMapping(value="/calculator", produces=MediaType.APPLICATION_JSON_VALUE)
	Double calculate(@Valid CalculatorRequestDTO calculatorDTO) {
		return calculator.add(calculatorDTO.getOperand1(), calculatorDTO.getOperand2());
	}
}
