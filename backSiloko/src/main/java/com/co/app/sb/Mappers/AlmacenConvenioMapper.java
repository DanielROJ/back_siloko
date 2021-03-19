package com.co.app.sb.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;

import com.co.app.sb.DTOs.AlmacenConvenioDto;
import com.co.app.sb.model.AlmacenConvenio;

@Mapper(componentModel = "spring", 
nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AlmacenConvenioMapper {
	
	@Mappings({
		@Mapping(source = "idAlmacen", target = "id"),
		@Mapping(source = "nit", target = "codeNit"),
		@Mapping(source = "nombreAlmacen", target = "name"),
		@Mapping(source = "pais", target = "country")
	})
	AlmacenConvenioDto toDto(AlmacenConvenio almacen);

	
	@Mappings({
		@Mapping(source = "id", target = "idAlmacen"),
		@Mapping(source = "codeNit", target = "nit"),
		@Mapping(source = "name", target = "nombreAlmacen"),
		@Mapping(source = "country", target = "pais")
	})
	AlmacenConvenio toEntity(AlmacenConvenioDto almacenDto);
}
