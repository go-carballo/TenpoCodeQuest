package com.tenpo.calculator.application.port.out;


import com.tenpo.calculator.application.model.dto.ApiCallHistoryDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ApiCallHistoryPort {

	void save(ApiCallHistoryDto apiCallHistoryDto);

	Page<ApiCallHistoryDto> getAllHistory(Pageable pageable);

}
