package com.tenpo.calculator.application.service;




import com.tenpo.calculator.application.port.input.CalculationPort;
import com.tenpo.calculator.application.port.out.PercentagePort;
import com.tenpo.calculator.domain.model.PercentageCalculation;
import com.tenpo.calculator.domain.model.error.ExceptionCalculating;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Service
@Slf4j
@RequiredArgsConstructor
public class CalculationService implements CalculationPort {

	private final PercentagePort percentagePort;



    @Override
	public Mono<BigDecimal> calculateWithPercentage(BigDecimal num1, BigDecimal num2) {
		return percentagePort.getPercentage()
				.map(percentage -> PercentageCalculation.builder()
						.num1(num1)
						.num2(num2)
						.percentage(percentage)
						.build().calculate())
				.doOnSuccess(result -> log.info("Calculated result: {}", result))
				.doOnError(error -> {
					log.error("Error occurred: {}", error.getMessage());
					throw new ExceptionCalculating(error.getMessage());
				});
	}


}
