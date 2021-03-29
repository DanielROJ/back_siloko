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
@Table(name = "SOLICITUD_CREDITO")
public class SolicitudCredito implements Serializable {


	@Id
	@Column(name = "id_solicitud_credito")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idSolicitudCredito;
	
	@Column(name = "codigo_credito")
	private String codigoCredito;
	
	@Column(name="fecha_solicitud")
	private Date fechaSolicitud;
	
	@Column(name="fecha_final_solicitud")
	private Date fechaFinalSolicitud;
	
	@Column(name = "numero_cuotas")
	private int numeroCuotas;
	
	@Column(name = "numeroCuotasPagas")
	private int numeroCuotasPagas;
	
	@Column(name="fecha_ultimo_pago")
	private Date fechaUltimoPago;
	

	@ManyToOne()
	@JoinColumn(name = "id_cliente", nullable = false)
	private Cliente cliente;
	

	@ManyToOne()
	@JoinColumn(name = "id_producto_cred", nullable = false)
	private ProductoCredito productoCredito;
	

	@ManyToOne()
	@JoinColumn(name = "id_funcionario", nullable = false)
	private Funcionario funcionarioSiloko;
	

	@ManyToOne()
	@JoinColumn(name = "id_funcionario_alm", nullable = false)
	private FuncionarioAlmacen funcionarioAlmacen;
	
	
	private EstadoCredito estado;


	public SolicitudCredito(String codigoCredito, Date fechaSolicitud, Date fechaFinalSolicitud, int numeroCuotas,
			int numeroCuotasPagas, Date fechaUltimoPago, Cliente cliente, ProductoCredito productoCredito,
			Funcionario funcionarioSiloko, FuncionarioAlmacen funcionarioAlmacen) {
		super();
		this.codigoCredito = codigoCredito;
		this.fechaSolicitud = fechaSolicitud;
		this.fechaFinalSolicitud = fechaFinalSolicitud;
		this.numeroCuotas = numeroCuotas;
		this.numeroCuotasPagas = numeroCuotasPagas;
		this.fechaUltimoPago = fechaUltimoPago;
		this.cliente = cliente;
		this.productoCredito = productoCredito;
		this.funcionarioSiloko = funcionarioSiloko;
		this.funcionarioAlmacen = funcionarioAlmacen;
	}


	public SolicitudCredito() {
		super();
	}


	public long getIdSolicitudCredito() {
		return idSolicitudCredito;
	}


	public void setIdSolicitudCredito(long idSolicitudCredito) {
		this.idSolicitudCredito = idSolicitudCredito;
	}


	public String getCodigoCredito() {
		return codigoCredito;
	}


	public void setCodigoCredito(String codigoCredito) {
		this.codigoCredito = codigoCredito;
	}


	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}


	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}


	public Date getFechaFinalSolicitud() {
		return fechaFinalSolicitud;
	}


	public void setFechaFinalSolicitud(Date fechaFinalSolicitud) {
		this.fechaFinalSolicitud = fechaFinalSolicitud;
	}


	public int getNumeroCuotas() {
		return numeroCuotas;
	}


	public void setNumeroCuotas(int numeroCuotas) {
		this.numeroCuotas = numeroCuotas;
	}


	public int getNumeroCuotasPagas() {
		return numeroCuotasPagas;
	}


	public void setNumeroCuotasPagas(int numeroCuotasPagas) {
		this.numeroCuotasPagas = numeroCuotasPagas;
	}


	public Date getFechaUltimoPago() {
		return fechaUltimoPago;
	}


	public void setFechaUltimoPago(Date fechaUltimoPago) {
		this.fechaUltimoPago = fechaUltimoPago;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public ProductoCredito getProductoCredito() {
		return productoCredito;
	}


	public void setProductoCredito(ProductoCredito productoCredito) {
		this.productoCredito = productoCredito;
	}


	public Funcionario getFuncionarioSiloko() {
		return funcionarioSiloko;
	}


	public void setFuncionarioSiloko(Funcionario funcionarioSiloko) {
		this.funcionarioSiloko = funcionarioSiloko;
	}


	public FuncionarioAlmacen getFuncionarioAlmacen() {
		return funcionarioAlmacen;
	}


	public void setFuncionarioAlmacen(FuncionarioAlmacen funcionarioAlmacen) {
		this.funcionarioAlmacen = funcionarioAlmacen;
	}


	public EstadoCredito getEstado() {
		return estado;
	}


	public void setEstado(EstadoCredito estado) {
		this.estado = estado;
	}
	
	
}
