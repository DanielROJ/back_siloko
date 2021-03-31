package com.co.app.sb.services;


import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.co.app.sb.DTOs.EstadoCreditoDto;
import com.co.app.sb.DTOs.SolicitudCreditoDto;
import com.co.app.sb.Mappers.SolicitudCreditoMapper;
import com.co.app.sb.model.SolicitudCredito;
import com.co.app.sb.repository.SolicitudCreditoRepository;
import com.co.app.sb.util.SolicitudCreditoException;

import DAOs_JDBC.SolicitudCreditoDAO;

@Service
public class SolicitudCreditoService {

	@Autowired
	private SolicitudCreditoRepository solicitudRep;

	@Autowired
	private ClienteService clienteSer;

	@Autowired
	private FuncionarioService funcionarioService;

	@Autowired
	private ProductoCreditoService productoService;

	@Autowired
	private EstadoCreditoService estadoCreditoService;

	@Autowired
	private SolicitudCreditoMapper solicitudMapper;
	
	@Autowired
	private FuncionarioAlmacenService funcionarioAlmService;
	
	@Autowired
	private CupoCreditoService cupoCreditoService;
	
	
	
	

	private Logger log = Logger.getLogger(SolicitudCreditoService.class.getName());

	public SolicitudCreditoDto GenerarSolicitudCredito(SolicitudCreditoDto solicitudDto) throws Exception {
		SolicitudCredito solicitud = this.solicitudMapper.toEntity(solicitudDto);
		long idCliente = solicitud.getCliente().getIdCliente();
		long idFuncionario = solicitud.getFuncionarioSiloko().getIdFuncionario();
		long idProducto = solicitud.getProductoCredito().getIdProductoCredito();

		if (this.clienteSer.getExistClient(idCliente) && this.funcionarioService.getExistFuncionario(idFuncionario)
				&& this.productoService.getExistProduct(idProducto)) {

			// SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");
			// Date date = new Date(System.currentTimeMillis());

			String parte_1_codigo = Long.toHexString(System.currentTimeMillis());

			String parte_2_codigo = Long.toHexString(idCliente);

			String parte_3_codigo = idProducto + "";

			String codigo = parte_3_codigo + "-" + parte_2_codigo + "-" + parte_1_codigo;

			long idEstadoCredito = SolicitudCreditoDAO.GenerarSolicitudCreditoCliente(idCliente, idFuncionario,
					idProducto, codigo);

			if (this.estadoCreditoService.getExistEstadoCredito(idEstadoCredito)) {

				EstadoCreditoDto estadoC = this.estadoCreditoService.getEstadoCredito(idEstadoCredito);
				SolicitudCredito sol = this.solicitudRep.findBycodigoCredito(codigo).orElseThrow();
				this.solicitudRep.EnlazarEstadoSolicitud(sol.getIdSolicitudCredito(), estadoC.getId());
				this.solicitudRep.flush();

				SolicitudCreditoDto solDto = this.solicitudMapper.toDto(sol);
				solDto.setStatus(estadoC);

				return solDto;

			} else {
				throw new SolicitudCreditoException("No se pudo generar la solicitud de credito");
			}

		}

		throw new NoSuchElementException();

	}

	public SolicitudCreditoDto getSolicitudByCodeAndIdCliente(String codigo, long documentoCliente) throws Exception {
		SolicitudCredito sol = this.solicitudRep.findBycodigoCredito(codigo).orElseThrow();
		if (sol.getCliente().getDocumentoId() == documentoCliente) {
			SolicitudCreditoDto solDto = this.solicitudMapper.toDto(sol);
			long idEstadoCredito = this.solicitudRep.BuscarUltimoEstadoCredito(solDto.getId()).orElseThrow();
			EstadoCreditoDto estadoC = this.estadoCreditoService.getEstadoCredito(idEstadoCredito);
			solDto.setStatus(estadoC);
			return solDto;
		} else {

			throw new NoSuchElementException();

		}

	}
	
	
	
	public boolean setIncioFinanciacionSolicitud(long idSolicitud,long idFuncionarioAlm, int numeroCoutas) throws Exception{
		
		if(this.solicitudRep.existsById(idSolicitud) && this.funcionarioAlmService.getExistFuncionarioAlmacen(idFuncionarioAlm) ) {
			
			log.info("idSolicitud : "+idSolicitud);
			
			SolicitudCredito sol = this.solicitudRep.BuscaPorId(idSolicitud).orElseThrow();
			log.info("sol lo tengo");
		
			BigDecimal precioProducto = sol.getProductoCredito().getValorProducto();
			
			BigDecimal cupoTotal = sol.getCliente().getCupoCredito().getValorTotalCupo();
			
			BigDecimal cupoUso = sol.getCliente().getCupoCredito().getValorCupoUso();
			
			BigDecimal cupoDisponible = cupoTotal.subtract(cupoUso);
			
		    if(precioProducto.doubleValue()< cupoDisponible.doubleValue()) {
		    	cupoUso = cupoUso.add(precioProducto);
		    	long idCupoCredito = sol.getCliente().getCupoCredito().getIdCupoCredito(); 
		    	this.cupoCreditoService.UpdateCupoUso(idCupoCredito,cupoUso);
		    	this.solicitudRep.ParametrosFinanciacion(numeroCoutas, idFuncionarioAlm, idSolicitud);
				this.solicitudRep.EnlazarEstadoSolicitud(idSolicitud,7);
				this.solicitudRep.flush();
				return true;
		    	
		    }else {
		    	throw new SolicitudCreditoException("No posee cupo suficiente");
		    }
			
		}else {
			throw new NoSuchElementException();
		}
	
	}
	
	
	
	
	
	public List<SolicitudCredito> getListSolicitudes() throws Exception{
		
		List<SolicitudCredito> solList = this.solicitudRep.findAll();
		return solList;
	}
	
	
	public SolicitudCredito getSolicitudCredito(long idSolicitud) {
		return this.solicitudRep.BuscaPorId(idSolicitud).orElseThrow();
	}
	
	
	public boolean existSolicitud() {
		return this.solicitudRep.existsById((long)24);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
