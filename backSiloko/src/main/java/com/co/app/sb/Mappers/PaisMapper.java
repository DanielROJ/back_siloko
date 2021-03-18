package com.co.app.sb.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import com.co.app.sb.DTOs.PaisDto;
import com.co.app.sb.model.Pais;

@Component
@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PaisMapper {
	
	@Mappings({
		@Mapping(source = "idPais", target = "id"),
		@Mapping(source = "nombrePais",target = "name"),
		@Mapping(source = "puntajePais",target = "valuePoint"),
		@Mapping(source = "moneda",target = "typeCoin"),
		@Mapping(source = "valorPunto",target = "pointAmount")
	})
	PaisDto toDto(Pais pais);
	
	
	@Mappings({
		@Mapping(source = "id", target = "idPais"),
		@Mapping(source = "name", target = "nombrePais"),
		@Mapping(source = "valuePoint", target = "puntajePais"),
		@Mapping(source = "typeCoin", target = "moneda"),
		@Mapping(source = "pointAmount", target = "valorPunto")
	})
	Pais toEntity(PaisDto paisDto);

}
