package com.co.app.sb.Mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;
import com.co.app.sb.DTOs.FuncionarioDto;
import com.co.app.sb.model.Funcionario;

@Component
@Mapper(componentModel = "spring", uses = {
		RolFuncionarioMapper.class }, nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FuncionarioMapper {

	@Mappings({ @Mapping(source = "idFuncionario", target = "id"),
			@Mapping(source = "codigoEmpleado", target = "codeEmploy"), 
			@Mapping(source = "nombres", target = "names"),
			@Mapping(source = "apellidos", target = "surNames"),
			@Mapping(source = "correo", target = "email"),
			@Mapping(source = "rolFuncionario", target = "rol") })
	FuncionarioDto toDto(Funcionario funcionario);

	@Mappings({ @Mapping(source = "id", target = "idFuncionario"),
			@Mapping(source = "codeEmploy", target = "codigoEmpleado"),
			@Mapping(source = "names", target = "nombres"),
			@Mapping(source = "surNames", target = "apellidos"),
			@Mapping(source = "email", target = "correo"),
			@Mapping(source = "rol", target = "rolFuncionario") })
	Funcionario toEntity(FuncionarioDto funcionarioDto);
	
	

	List<FuncionarioDto> entityListToDtoList(List<Funcionario> listFuncionario);
	
	List<Funcionario> dtoListToEntityList(List<FuncionarioDto> listFuncionarioDto);

}
