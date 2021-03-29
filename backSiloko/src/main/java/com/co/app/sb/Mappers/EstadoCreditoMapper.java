package com.co.app.sb.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import com.co.app.sb.DTOs.EstadoCreditoDto;
import com.co.app.sb.model.EstadoCredito;

@Component
@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EstadoCreditoMapper {

	@Mappings({
		@Mapping(source = "idEstadoCredito",target = "id"),
		@Mapping(source = "estado",target = "status"),
		@Mapping(source = "descripcion",target = "description")
	})
	EstadoCreditoDto toDto(EstadoCredito estado);
	
	
	@Mappings({
		@Mapping(source = "id",target = "idEstadoCredito"),
		@Mapping(source = "status",target = "estado"),
		@Mapping(source = "description",target = "descripcion")
	})
	EstadoCredito toEntity(EstadoCreditoDto estadoDto);
	
}
