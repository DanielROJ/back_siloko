package com.co.app.sb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.ParameterMode;


@Entity
@Table(name = "CUPO_CREDITO")
@NamedStoredProcedureQueries({
	
	@NamedStoredProcedureQuery(
	        name = "CALCULO_CUPO_CREDITO",
	        procedureName = "ADMIN_SILOKO.CALCULO_CUPO",
	        parameters = {
	        		@StoredProcedureParameter(mode=ParameterMode.IN, name="id_cliente", type=Long.class),
	        	    @StoredProcedureParameter(mode=ParameterMode.OUT, name="response", type=Integer.class)
	        	    
	    })
})
public class CupoCredito implements Serializable {

	@Id
	@Column(name = "id_cupo_credito")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCupoCredito;
	
	@Column(name = "val_total_cupo")
	private BigDecimal valorTotalCupo;
	
	@Column(name = "val_cupo_uso")
	private BigDecimal valorCupoUso;
	
	@Column(name = "val_cupo_tramite")
	private BigDecimal valorCupoTramite;
	
	@Column(name = "fecha_calculado")
	private Date fechaCalculado;
	
	 @OneToOne
	 @JoinColumn(name = "id_cliente")   
	 private Cliente user;
	
	@ManyToOne()
	@JoinColumn(name = "id_estado_cupo", nullable = false)
	private EstadoCupo estadoCupo;

	public CupoCredito(BigDecimal valorTotalCupo, BigDecimal valorCupoUso, BigDecimal valorCupoTramite, Cliente cliente,
			EstadoCupo estadoCupo) {
		super();
		this.valorTotalCupo = valorTotalCupo;
		this.valorCupoUso = valorCupoUso;
		this.valorCupoTramite = valorCupoTramite;
		this.estadoCupo = estadoCupo;
	}
	
	public CupoCredito() {
		super();
	}

	public long getIdCupoCredito() {
		return idCupoCredito;
	}


	public void setIdCupoCredito(long idCupoCredito) {
		this.idCupoCredito = idCupoCredito;
	}

	public BigDecimal getValorTotalCupo() {
		return valorTotalCupo;
	}

	public void setValorTotalCupo(BigDecimal valorTotalCupo) {
		this.valorTotalCupo = valorTotalCupo;
	}

	public BigDecimal getValorCupoUso() {
		return valorCupoUso;
	}

	public void setValorCupoUso(BigDecimal valorCupoUso) {
		this.valorCupoUso = valorCupoUso;
	}

	public BigDecimal getValorCupoTramite() {
		return valorCupoTramite;
	}

	public void setValorCupoTramite(BigDecimal valorCupoTramite) {
		this.valorCupoTramite = valorCupoTramite;
	}

	public EstadoCupo getEstadoCupo() {
		return estadoCupo;
	}

	public void setEstadoCupo(EstadoCupo estadoCupo) {
		this.estadoCupo = estadoCupo;
	}


	public Date getFechaCalculado() {
		return fechaCalculado;
	}


	public void setFechaCalculado(Date fechaCalculado) {
		this.fechaCalculado = fechaCalculado;
	}
	
}
