package com.co.app.sb.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;


import com.co.app.sb.DTOs.ProductoCreditoDto;
import com.co.app.sb.model.ProductoCredito;

@Component
@Mapper(componentModel = "spring", uses = {AlmacenConvenioMapper.class},
nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductoCreditoMapper {

	@Mappings({
		@Mapping(source = "idProductoCredito",target = "id"),
		@Mapping(source = "nombreProducto",target = "nameProduct"),
		@Mapping(source = "codigoSiloko",target = "codeSiloko"),
		@Mapping(source = "valorProducto",target = "valueProduct"),
		@Mapping(source = "almacenConvenio",target = "store")
	})
	ProductoCreditoDto toDto(ProductoCredito producto);
	
	
	
	@Mappings({
		@Mapping(source = "id",target = "idProductoCredito"),
		@Mapping(source = "nameProduct",target = "nombreProducto"),
		@Mapping(source = "codeSiloko",target = "codigoSiloko"),
		@Mapping(source = "valueProduct",target = "valorProducto"),
		@Mapping(source = "store",target = "almacenConvenio")
	})
	ProductoCredito toEntity(ProductoCreditoDto productoDto);
	
	
	
}
