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
@Table(name = "FUNCIONARIO_ALMACEN")
public class FuncionarioAlmacen implements Serializable {

	@Id
	@Column(name = "id_funcionario_alm")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idFuncionarioAlmacen;
	
	@Column(name = "codigo_empleado")
	private long codigoEmpleado;
	
	@Column(name = "nombres")
	private String nombres;
	
	@Column(name = "apellidos")
	private String apellidos;
	
	@Column(name = "correo")
	private String correo;
	
	@ManyToOne()
	@JoinColumn(name = "id_almacen_convenio", nullable = false)
	private AlmacenConvenio almacenConvenio;

	public FuncionarioAlmacen(long codigoEmpleado, String nombres, String apellidos, String correo,
			AlmacenConvenio almacenConvenio) {
		super();
		this.codigoEmpleado = codigoEmpleado;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correo = correo;
		this.almacenConvenio = almacenConvenio;
	}

	public FuncionarioAlmacen() {
		super();
	}

	

	public long getIdFuncionarioAlmacen() {
		return idFuncionarioAlmacen;
	}

	public void setIdFuncionarioAlmacen(long idFuncionarioAlmacen) {
		this.idFuncionarioAlmacen = idFuncionarioAlmacen;
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

	public AlmacenConvenio getAlmacenConvenio() {
		return almacenConvenio;
	}

	public void setAlmacenConvenio(AlmacenConvenio almacenConvenio) {
		this.almacenConvenio = almacenConvenio;
	}
	
	
	
	
	
}
