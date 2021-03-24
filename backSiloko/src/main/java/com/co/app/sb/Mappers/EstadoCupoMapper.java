package com.co.app.sb.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;

import com.co.app.sb.DTOs.EstadoCupoDto;
import com.co.app.sb.model.EstadoCupo;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EstadoCupoMapper {
	
	
	@Mappings({
		@Mapping(source = "idEstadoCupo", target = "id"),
		@Mapping(source = "estado", target = "status"),
		@Mapping(source = "descripcion", target = "description")
	})
	EstadoCupoDto toDto(EstadoCupo estadoCupo);
	
	
	@Mappings({
		@Mapping(source = "id", target = "idEstadoCupo"),
		@Mapping(source = "status", target = "estado"),
		@Mapping(source = "description", target = "descripcion")
	})
	EstadoCupo toEntity(EstadoCupoDto estadoCupoDto);
	
	

}
