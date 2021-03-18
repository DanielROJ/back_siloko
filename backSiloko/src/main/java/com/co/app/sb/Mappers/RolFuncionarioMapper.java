package com.co.app.sb.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;

import com.co.app.sb.DTOs.RolFuncionarioDto;
import com.co.app.sb.model.RolFuncionario;

@Mapper(componentModel = "spring", 
nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RolFuncionarioMapper {

	
	@Mappings({
		@Mapping(source = "idRolFuncionario", target = "id"),
		@Mapping(source = "nombreRol", target = "nameRol")
		})
	RolFuncionarioDto toDto(RolFuncionario rolFuncionario);
	
	
	@Mappings({
		@Mapping(source = "id", target = "idRolFuncionario"),
		@Mapping(source = "nameRol", target = "nombreRol")
	})
	RolFuncionario toEntity(RolFuncionarioDto rolFuncioanarioDto);
	
	
}
