package com.co.app.sb.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;

import com.co.app.sb.DTOs.CupoCreditoDto;
import com.co.app.sb.model.CupoCredito;

@Mapper(componentModel = "spring", uses = EstadoCupoMapper.class,
nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CupoCreditoMapper {
	
	@Mappings({
			@Mapping(source = "idCupoCredito",target = "id"),
			@Mapping(source = "valorTotalCupo",target = "totalSizeCredit"),
			@Mapping(source = "valorCupoUso",target = "sizeCreditUsed"),
			@Mapping(source = "valorCupoTramite",target = "sizeTransactionCredit"),
			@Mapping(source = "fechaCalculado",target = "dateLastStudyCredit"),
			@Mapping(source = "estadoCupo",target = "statusCredit")	
	})
	CupoCreditoDto toDto(CupoCredito cupoCredito);
	
	@Mappings({
		@Mapping(source = "id",target = "idCupoCredito"),
		@Mapping(source = "totalSizeCredit",target = "valorTotalCupo"),
		@Mapping(source = "sizeCreditUsed",target = "valorCupoUso"),
		@Mapping(source = "sizeTransactionCredit",target = "valorCupoTramite"),
		@Mapping(source = "dateLastStudyCredit",target = "fechaCalculado"),
		@Mapping(source = "statusCredit",target = "estadoCupo")	
	})
	CupoCredito toEntity(CupoCreditoDto cupoCredito);

}
