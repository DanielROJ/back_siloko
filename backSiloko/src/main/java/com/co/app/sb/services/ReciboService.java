package com.co.app.sb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.co.app.sb.DTOs.ClienteProductoTelDto;
import com.co.app.sb.DTOs.ReciboDto;
import com.co.app.sb.DTOs.SolicitudCreditoDto;
import com.co.app.sb.Mappers.ClienteProductoTelMapper;
import com.co.app.sb.Mappers.ReciboMapper;
import com.co.app.sb.Mappers.SolicitudCreditoMapper;
import com.co.app.sb.model.ClienteProductoTel;
import com.co.app.sb.model.Recibo;
import com.co.app.sb.model.SolicitudCredito;
import com.co.app.sb.repository.ClienteProductoTelRepository;
import com.co.app.sb.repository.ReciboRepository;

import DAOs_JDBC.ReciboDAO;

@Service
public class ReciboService {
	
	@Autowired
	private ReciboRepository reciboRep;
	
	@Autowired
	private ReciboMapper reciboMapper;
	
	@Autowired
	private SolicitudCreditoMapper solicitudMapper;
	
	@Autowired
	private ClienteProductoTelMapper clienteProductoMapper;
	
	@Autowired
	private ClienteProductoTelRepository clienteProductoTelRep;
	
	/**
	 * Metodo que permite traer los recibos generados de un cliente, con paginacion incluida
	 * @param idCliente
	 * @param numberPage
	 * @param numberRegisters
	 * @return
	 * @throws Exception
	 */
	public List<ReciboDto> getListRecibosByIdCliente(long idCliente, int numberPage, int numberRegisters) throws Exception{
		Pageable objectPaginacion =  PageRequest.of(numberPage, numberRegisters,Sort.by("fechaGeneracion").descending());
		List<Recibo> listRecibo = this.reciboRep.findAllBycliente_idCliente(idCliente, objectPaginacion);
		return this.reciboMapper.entityListToDtoList(listRecibo);
	}
	
	
	
	public long getCountNumberRowsRecibosCliente(long idCliente) throws Exception{
		return this.reciboRep.countBycliente_idCliente(idCliente);
	}
	
	
	public boolean ExecuteProcesoMasivo() throws Exception {
		boolean res = false;
		int processResponse = ReciboDAO.ProcesoMasivoGenerarRecibos();
		if(processResponse>=1) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public List<SolicitudCreditoDto> getListSolicitudesRecibos(long idRecibo) throws Exception{
		List<SolicitudCredito> listSolicitudes =  this.reciboRep.GetSolicitudesRecibos(idRecibo);
		return this.solicitudMapper.entityListToDtoList(listSolicitudes);
	}
	
	public List<ClienteProductoTelDto> getListProductosRecibos(long idRecibo) throws Exception{
		List<ClienteProductoTel> listClienteProducto = this.clienteProductoTelRep.ReciboProductos(idRecibo);
		return this.clienteProductoMapper.entityListToDtoList(listClienteProducto);
	}
	

	

}
