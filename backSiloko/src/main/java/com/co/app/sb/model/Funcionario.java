package com.co.app.sb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FUNCIONARIO")
public class Funcionario implements Serializable {

	@Id
	@Column(name = "id_cliente")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idFuncionario;
	
	@Column(name = "codigo_empleado")
	private long codigoEmpleado;
	
	@Column(name = "nombres")
	private String nombres;
	
	@Column(name = "apellidos")
	private String apellidos;
	
	@Column(name = "correo")
	private String correo;
	
	@ManyToOne()
	@JoinColumn(name = "id_rol_fun", nullable = false)
	private RolFuncionario rolFuncionario;

	public Funcionario(long codigoEmpleado, String nombres, String apellidos, String correo,
			RolFuncionario rolFuncionario) {
		super();
		this.codigoEmpleado = codigoEmpleado;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correo = correo;
		this.rolFuncionario = rolFuncionario;
	}

	public Funcionario() {
		super();
	}

	public long getIdFuncionario() {
		return idFuncionario;
	}

	public long getCodigoEmpleado() {
		return codigoEmpleado;
	}

	public void setCodigoEmpleado(long codigoEmpleado) {
		this.codigoEmpleado = codigoEmpleado;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public RolFuncionario getRolFuncionario() {
		return rolFuncionario;
	}

	public void setRolFuncionario(RolFuncionario rolFuncionario) {
		this.rolFuncionario = rolFuncionario;
	}
	
	
	
	
}
