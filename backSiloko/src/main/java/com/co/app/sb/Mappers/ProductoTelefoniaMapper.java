package com.co.app.sb.Mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import com.co.app.sb.DTOs.ProductoTelefoniaDto;
import com.co.app.sb.DTOs.ProductoTelefoniaDto;
import com.co.app.sb.model.ProductoTelefonia;
import com.co.app.sb.model.RangoAntiguedad;

@Component
@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductoTelefoniaMapper {
	
	@Mappings({
		@Mapping(source = "idProductoTelefonia",target = "id"),
		@Mapping(source = "nombreProducto",target = "nameProduct"),
		@Mapping(source = "numeroMinutos",target = "numberMinutes"),
		@Mapping(source = "puntajeProductoTelefonia",target = "amountPoints"),
	})
	ProductoTelefoniaDto toDto(ProductoTelefonia producto);
	
	
	@Mappings({
		@Mapping(source = "id",target = "idProductoTelefonia"),
		@Mapping(source = "nameProduct",target = "nombreProducto"),
		@Mapping(source = "numberMinutes",target = "numeroMinutos"),
		@Mapping(source = "amountPoints",target = "puntajeProductoTelefonia"),
	})
	ProductoTelefonia toEntity(ProductoTelefoniaDto productoDto);
	
List<ProductoTelefoniaDto> entityListToDtoList(List<ProductoTelefonia > listProducto);
	
List<ProductoTelefonia> dtoListToEntityList(List<ProductoTelefoniaDto> listProducto);

}
