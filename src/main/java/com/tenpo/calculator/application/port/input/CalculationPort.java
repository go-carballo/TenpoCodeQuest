package com.tenpo.calculator.application.port.input;

import reactor.core.publisher.Mono;

import java.math.BigDecimal;

public interface CalculationPort {
	Mono<BigDecimal> calculateWithPercentage(BigDecimal num1, BigDecimal num2);
}

