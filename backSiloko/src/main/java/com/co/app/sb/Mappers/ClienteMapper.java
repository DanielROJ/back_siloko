package com.co.app.sb.Mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import com.co.app.sb.DTOs.CiudadDto;
import com.co.app.sb.DTOs.ClienteDto;
import com.co.app.sb.model.Ciudad;
import com.co.app.sb.model.Cliente;

@Component
@Mapper(componentModel = "spring", uses = {EstratoEconomicoMapper.class, CiudadMapper.class,RangoAntiguedadMapper.class,RangoCantidadProductosMapper.class},
nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClienteMapper {

	@Mappings({
		@Mapping(source = "idCliente", target = "id"),
		@Mapping(source = "nombres", target = "names"),
		@Mapping(source = "apellidos", target = "surNames"),
		@Mapping(source = "correo", target = "email"),
		@Mapping(source = "fechaRegistro", target = "dateRegister"),
		@Mapping(source = "documentoId", target = "idDocument"),
		@Mapping(source = "ciudad", target = "city"),
		@Mapping(source = "rangoAnt", target = "rangeOld"),
		@Mapping(source = "estrato", target = "classEconomic"),
		@Mapping(source = "rangoCantidadProductos", target = "rangeAmountProducts")
	})
	ClienteDto toDto(Cliente cliente);
	

	@Mappings({
		@Mapping(source = "id", target = "idCliente"),
		@Mapping(source = "names", target = "nombres"),
		@Mapping(source = "surNames", target = "apellidos"),
		@Mapping(source = "email", target = "correo"),
		@Mapping(source = "dateRegister", target = "fechaRegistro"),
		@Mapping(source = "clienteDto.idDocument", target = "documento"),
		@Mapping(source = "city", target = "ciudad"),
		@Mapping(source = "rangeOld", target = "rangoAnt"),
		@Mapping(source = "classEconomic", target = "estrato"),
		@Mapping(source = "rangeAmountProducts", target = "rangoCantidadProductos")
	})
	Cliente toEntity(ClienteDto clienteDto);
	 
	
	
	
	List<ClienteDto> entityListToDtoList(List<Cliente> listCliente);
	
	List<Ciudad> dtoListToEntityList(List<ClienteDto> listClienteDto);
	
}
