package com.tenpo.calculator.infrastructure.input.controller;


import com.tenpo.calculator.application.port.input.CalculationPort;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/calculate")
@RequiredArgsConstructor
public class CalculationController {

	private final CalculationPort calculationPort;

	@GetMapping
	public Mono<ResponseEntity<BigDecimal>> calculate(@RequestParam @NonNull BigDecimal num1, @RequestParam @NonNull BigDecimal num2) {
		return calculationPort.calculateWithPercentage(num1, num2)
				.map(ResponseEntity::ok)
				.defaultIfEmpty(ResponseEntity.badRequest().build());
	}
}

