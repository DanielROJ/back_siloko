package com.co.app.sb.Mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import com.co.app.sb.DTOs.CiudadDto;
import com.co.app.sb.model.Ciudad;


@Component
@Mapper(componentModel = "spring", uses = PaisMapper.class,
nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CiudadMapper {

	@Mappings({
			@Mapping(source = "idCiudad", target = "id"),
			@Mapping(source = "nombreCiudad", target = "name"),
			@Mapping(source = "puntajeCiudad", target = "amountPoints"),
			@Mapping(source = "pais", target = "country")
	})
	CiudadDto toDto(Ciudad ciudad);
	
	@Mappings({
		@Mapping(source = "id", target = "idCiudad"),
		@Mapping(source = "name", target = "nombreCiudad"),
		@Mapping(source = "amountPoints", target = "puntajeCiudad"),
		@Mapping(source = "country", target = "pais")
	})
	Ciudad toEntity(CiudadDto ciudadDto);
	

	List<CiudadDto> entityListToDtoList(List<Ciudad> listCiudad);
	
	List<Ciudad> dtoListToEntityList(List<CiudadDto> listCiudadDto);
	
}
