package com.tenpo.calculator.infrastructure.model.mapper;



import com.tenpo.calculator.application.model.dto.ApiCallHistoryDto;
import com.tenpo.calculator.infrastructure.model.entity.ApiCallHistoryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApiCallHistoryMapper {

	ApiCallHistoryEntity toEntity(ApiCallHistoryDto domain);

	ApiCallHistoryDto toDto(ApiCallHistoryEntity entity);
}
