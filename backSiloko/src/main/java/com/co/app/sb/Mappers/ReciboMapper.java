package com.co.app.sb.Mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;
import com.co.app.sb.DTOs.ReciboDto;
import com.co.app.sb.model.Recibo;

@Component
@Mapper(componentModel = "spring", uses = ClienteMapper.class,
nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReciboMapper {

	
	@Mappings({
		@Mapping(source = "idRecibo", target = "id"),
		@Mapping(source = "valorTotalCreditos", target = "valTotalCuotaCredit"),
		@Mapping(source = "valorTotalProductosTel", target = "valTotalProduct"),
		@Mapping(source = "totalPagarCreditos", target = "valTotalCredit"),
		@Mapping(source = "total", target = "total"),
		@Mapping(source = "estadoPago", target = "statusPay"),
		@Mapping(source = "fechaGeneracion", target = "dateGenerated"),
		@Mapping(source = "fechaLimPago", target = "dateLimPay"),
		@Mapping(source = "cliente", target = "client"),
	})
	ReciboDto toDto(Recibo recibo);
	
	
	@Mappings({
		@Mapping(source = "id", target = "idRecibo"),
		@Mapping(source = "valTotalCuotaCredit", target = "valorTotalCreditos"),
		@Mapping(source = "valTotalProduct", target = "valorTotalProductosTel"),
		@Mapping(source = "valTotalCredit", target = "totalPagarCreditos"),
		@Mapping(source = "total", target = "total"),
		@Mapping(source = "statusPay", target = "estadoPago"),
		@Mapping(source = "dateGenerated", target = "fechaGeneracion"),
		@Mapping(source = "dateLimPay", target = "fechaLimPago"),
		@Mapping(source = "client", target = "cliente"),
	})
	Recibo toEntity(ReciboDto reciboDto);
	
	

	List<ReciboDto> entityListToDtoList(List<Recibo> listRecibos);
	
	List<Recibo> dtoListToEntityList(List<ReciboDto> listRecibosDto);
}
