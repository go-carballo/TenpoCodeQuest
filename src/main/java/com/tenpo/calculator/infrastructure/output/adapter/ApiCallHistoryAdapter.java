package com.tenpo.calculator.infrastructure.output.adapter;




import com.tenpo.calculator.application.model.dto.ApiCallHistoryDto;
import com.tenpo.calculator.application.port.out.ApiCallHistoryPort;
import com.tenpo.calculator.infrastructure.model.entity.ApiCallHistoryEntity;
import com.tenpo.calculator.infrastructure.model.mapper.ApiCallHistoryMapper;
import com.tenpo.calculator.infrastructure.output.repository.ApiCallHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ApiCallHistoryAdapter implements ApiCallHistoryPort {

	private final ApiCallHistoryRepository apiCallHistoryRepository;
	private final ApiCallHistoryMapper apiCallHistoryMapper;

	@Override
	public void save(ApiCallHistoryDto apiCallHistory) {
		apiCallHistoryRepository.save(ApiCallHistoryEntity.builder()
				.timestamp(LocalDateTime.now())
				.endpoint(apiCallHistory.getEndpoint())
				.requestParams(apiCallHistory.getRequestParams())
				.response(apiCallHistory.getResponse())
				.status(apiCallHistory.getStatus())
				.build());
	}

	public Page<ApiCallHistoryDto> getAllHistory(Pageable pageable) {
		return apiCallHistoryRepository.findAll(pageable)
				.map(apiCallHistoryMapper::toDto);
	}
}

