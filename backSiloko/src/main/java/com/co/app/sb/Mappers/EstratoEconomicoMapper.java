package com.co.app.sb.Mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;
import com.co.app.sb.DTOs.EstratoEconomicoDto;
import com.co.app.sb.model.EstratoEconomico;

@Component
@Mapper(componentModel = "spring",
nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EstratoEconomicoMapper {

	@Mappings({
		@Mapping(source = "idEstratoEconomico", target = "id"),
		@Mapping(source = "numeroEstrato", target = "numClassEconomic"),
		@Mapping(source = "puntajeEstrato", target = "amountPoints")
	})
	EstratoEconomicoDto toDto(EstratoEconomico estrato);
	
	@Mappings({
		@Mapping(source = "id", target = "idEstratoEconomico"),
		@Mapping(source = "numClassEconomic", target = "numeroEstrato"),
		@Mapping(source = "amountPoints", target = "puntajeEstrato")
	})
	EstratoEconomico toEntity(EstratoEconomicoDto estratoDto);
	
	

	List<EstratoEconomicoDto> entityListToDtoList(List<EstratoEconomico> listEstrato);
	
	List<EstratoEconomico> dtoListToEntityList(List<EstratoEconomicoDto> listEstratoDto);
}
