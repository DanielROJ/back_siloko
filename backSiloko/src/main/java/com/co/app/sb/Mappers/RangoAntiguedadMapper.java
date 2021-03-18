package com.co.app.sb.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;

import com.co.app.sb.DTOs.RangoAntiguedadDto;
import com.co.app.sb.model.RangoAntiguedad;

@Mapper(componentModel = "spring", 
nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RangoAntiguedadMapper {

	
	@Mappings({
		@Mapping(source = "idRangoAntiguedad", target = "id"),
		@Mapping(source = "rango", target = "rangeOld"),
		@Mapping(source = "puntajeRango", target = "amountPoints")
	})
	RangoAntiguedadDto toDto(RangoAntiguedad rango);
	
	@Mappings({
		@Mapping(source = "id", target = "idRangoAntiguedad"),
		@Mapping(source = "rangeOld", target = "rango"),
		@Mapping(source = "amountPoints", target = "puntajeRango")
	})
	RangoAntiguedad toEntity(RangoAntiguedadDto rangoDto);
	
}
