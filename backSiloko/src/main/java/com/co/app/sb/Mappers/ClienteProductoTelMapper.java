package com.co.app.sb.Mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;
import com.co.app.sb.DTOs.ClienteProductoTelDto;
import com.co.app.sb.model.ClienteProductoTel;

@Component
@Mapper(componentModel = "spring", uses = ProductoTelefoniaMapper.class,
nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClienteProductoTelMapper {
	
	@Mappings({
		@Mapping(source = "idClienteProductoTel",target = "id"),
		@Mapping(source = "productoTel",target = "productTel"),
		@Mapping(source = "precioProducto",target = "priceProduct"),
		@Mapping(source = "numeroLinea",target = "")
	})
	ClienteProductoTelDto toDto(ClienteProductoTel clienteProducto);
	
	
	@Mappings({
		@Mapping(source = "id",target = "idClienteProductoTel"),
		@Mapping(source = "productTel",target = "productoTel"),
		@Mapping(source = "priceProduct",target = "precioProducto"),
		@Mapping(source = "numberLine",target = "numeroLinea")
	})
	ClienteProductoTel toEntity(ClienteProductoTelDto clienteProductoDto);
	
	List<ClienteProductoTelDto> entityListToDtoList(List<ClienteProductoTel> listCliente);
	
	List<ClienteProductoTel> dtoListToEntityList(List<ClienteProductoTelDto> listClienteDto);
	

}
