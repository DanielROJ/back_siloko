package com.co.app.sb.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import com.co.app.sb.DTOs.FuncionarioAlmacenDto;
import com.co.app.sb.model.FuncionarioAlmacen;

@Component
@Mapper(componentModel = "spring", uses = AlmacenConvenioMapper.class,
nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FuncionarioAlmacenMapper {
	
	@Mappings({
		@Mapping(source = "idFuncionarioAlmacen", target = "id"),
		@Mapping(source = "codigoEmpleado", target = "codeEmploy"),
		@Mapping(source = "nombres", target = "names"),
		@Mapping(source = "apellidos", target = "surNames"),
		@Mapping(source = "correo", target = "email"),
		@Mapping(source = "almacenConvenio", target = "store")
	})
	FuncionarioAlmacenDto toDto(FuncionarioAlmacen funcionarioAlm);
	
	
	
	@Mappings({
		@Mapping(source = "id", target = "idFuncionarioAlmacen"),
		@Mapping(source = "codeEmploy", target = "codigoEmpleado"),
		@Mapping(source = "names", target = "nombres"),
		@Mapping(source = "surNames", target = "apellidos"),
		@Mapping(source = "email", target = "correo"),
		@Mapping(source = "store", target = "almacenConvenio")
	})
	FuncionarioAlmacen toEntity(FuncionarioAlmacenDto funcionarioAlmDto);

}
