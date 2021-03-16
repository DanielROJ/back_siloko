package com.co.app.sb.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTE")
public class Cliente implements Serializable {
	
	@Id
	@Column(name = "id_cliente")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCliente;
	
	@Column(name = "nombres")
	private String nombres;
	
	@Column(name = "apellidos")
	private String apellidos;
	
	@Column(name="correo")
	private String correo;
	
	@Column(name="fecha_registro")
	private Date fechaRegistro;
	
	@Column(name = "documento_id")
	private long documentoId; 
	
	@ManyToOne()
	@JoinColumn(name = "id_ciudad", nullable = false)
	private Ciudad ciudad;
	
	@ManyToOne()
	@JoinColumn(name = "id_rango_ant", nullable = false)
	private RangoAntiguedad rangoAnt;
	
	@ManyToOne()
	@JoinColumn(name = "id_estrato", nullable = false)
	private EstratoEconomico estrato;
	
	@ManyToOne()
	@JoinColumn(name = "id_rango_can_productos", nullable = false)
	private RangoCantidadProductos rangoCantidadProductos;
	
	public Cliente() {
		super();
	}
	
	public Cliente(String nombres, String apellidos, String correo, Date fechaRegistro, long documento, Ciudad ciudad,
			RangoAntiguedad rangoAnt, EstratoEconomico estrato, RangoCantidadProductos rangoCantidadProductos) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correo = correo;
		this.fechaRegistro = fechaRegistro;
		this.documentoId = documento;
		this.ciudad = ciudad;
		this.rangoAnt = rangoAnt;
		this.estrato = estrato;
		this.rangoCantidadProductos = rangoCantidadProductos;
	}


	public long getIdCliente() {
		return idCliente;
	}



	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
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

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public long getDocumento() {
		return documentoId;
	}

	public void setDocumento(long documento) {
		this.documentoId = documento;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public RangoAntiguedad getRangoAnt() {
		return rangoAnt;
	}

	public void setRangoAnt(RangoAntiguedad rangoAnt) {
		this.rangoAnt = rangoAnt;
	}

	public EstratoEconomico getEstrato() {
		return estrato;
	}

	public void setEstrato(EstratoEconomico estrato) {
		this.estrato = estrato;
	}

	public RangoCantidadProductos getRangoCantidadProductos() {
		return rangoCantidadProductos;
	}

	public void setRangoCantidadProductos(RangoCantidadProductos rangoCantidadProductos) {
		this.rangoCantidadProductos = rangoCantidadProductos;
	}
	
	
	
	
	
}
