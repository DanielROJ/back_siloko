package com.co.app.sb.Mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;
import com.co.app.sb.DTOs.SolicitudCreditoDto;
import com.co.app.sb.model.SolicitudCredito;

@Component
@Mapper(componentModel = "spring", 
uses = {ClienteMapper.class, FuncionarioMapper.class, ProductoCreditoMapper.class,
		FuncionarioAlmacenMapper.class},
nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SolicitudCreditoMapper {
	
	@Mappings({
		@Mapping(source = "idSolicitudCredito", target = "id"),
		@Mapping(source = "codigoCredito", target = "codeCredito"),
		@Mapping(source = "fechaSolicitud", target = "dateRequest"),
		@Mapping(source = "fechaFinalSolicitud", target = "datefinalRequest"),
		@Mapping(source = "numeroCuotas", target = "numFees"),
		@Mapping(source = "numeroCuotasPagas", target = "numFeesPaid"),
		@Mapping(source = "numeroCuotasGeneradas", target = "numFeesGenerated"),
		@Mapping(source = "fechaUltimoPago", target = "dateLastPaid"),
		@Mapping(source = "cliente", target = "client"),
		@Mapping(source = "productoCredito", target = "product"),
		@Mapping(source = "funcionarioSiloko", target = "employManager"),
		@Mapping(source = "funcionarioAlmacen", target = "employStore")
	})
	SolicitudCreditoDto toDto(SolicitudCredito solicitud);
	
	
	
	
	@Mappings({
		@Mapping(source = "id", target = "idSolicitudCredito"),
		@Mapping(source = "codeCredito", target = "codigoCredito"),
		@Mapping(source = "dateRequest", target = "fechaSolicitud"),
		@Mapping(source = "datefinalRequest", target = "fechaFinalSolicitud"),
		@Mapping(source = "numFees", target = "numeroCuotas"),
		@Mapping(source = "numFeesPaid", target = "numeroCuotasPagas"),
		@Mapping(source = "numFeesGenerated", target = "numeroCuotasGeneradas"),
		@Mapping(source = "dateLastPaid", target = "fechaUltimoPago"),
		@Mapping(source = "client", target = "cliente"),
		@Mapping(source = "product", target = "productoCredito"),
		@Mapping(source = "employManager", target = "funcionarioSiloko"),
		@Mapping(source = "employStore", target = "funcionarioAlmacen")	
	})
	SolicitudCredito toEntity(SolicitudCreditoDto solicitudDto);
	
	
	
	List<SolicitudCreditoDto> entityListToDtoList(List<SolicitudCredito> listCliente);
	
	List<SolicitudCredito> dtoListToEntityList(List<SolicitudCreditoDto> listClienteDto);
	
	

}
