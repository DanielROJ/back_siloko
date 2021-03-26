package com.co.app.sb.Mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import com.co.app.sb.DTOs.RangoAntiguedadDto;
import com.co.app.sb.DTOs.RangoCantidadProductosDto;
import com.co.app.sb.model.RangoAntiguedad;
import com.co.app.sb.model.RangoCantidadProductos;

@Component
@Mapper(componentModel = "spring",
nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RangoCantidadProductosMapper {
	
	@Mappings({
		@Mapping(source = "idRangoCantidadProducto", target = "id"),
		@Mapping(source = "rango", target = "rangeAmountProducts"),
		@Mapping(source = "puntajeCantidadProducto", target = "amountPoints"),
	})
	RangoCantidadProductosDto toDto(RangoCantidadProductos rangoCantidad);
	
	
	@Mappings({
		@Mapping(source = "id", target = "idRangoCantidadProducto"),
		@Mapping(source = "rangeAmountProducts", target = "rango"),
		@Mapping(source = "amountPoints", target = "puntajeCantidadProducto"),
	})
	RangoCantidadProductos toEntity(RangoCantidadProductosDto rangoCantidadDto);
	
	List<RangoCantidadProductosDto> entityListToDtoList(List<RangoCantidadProductos> listRango);
	
	List<RangoCantidadProductos> dtoListToEntityList(List<RangoCantidadProductosDto> listRango);

}
