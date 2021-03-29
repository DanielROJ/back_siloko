package com.co.app.sb.services;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.app.sb.DTOs.SolicitudCreditoDto;
import com.co.app.sb.Mappers.SolicitudCreditoMapper;
import com.co.app.sb.model.EstadoCredito;
import com.co.app.sb.model.SolicitudCredito;
import com.co.app.sb.repository.ClienteRepository;
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

	public SolicitudCreditoDto GenerarSolicitudCredito(SolicitudCredito solicitud) throws Exception {
		long idCliente = solicitud.getCliente().getIdCliente();
		long idFuncionario = solicitud.getFuncionarioSiloko().getIdFuncionario();
		long idProducto = solicitud.getProductoCredito().getIdProductoCredito();

		if (this.clienteSer.getExistClient(idCliente) && this.funcionarioService.getExistFuncionario(idFuncionario)
				&& this.productoService.getExistProduct(idProducto)) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhh");
			Date date = new Date(System.currentTimeMillis());

			String parte_1_codigo = formatter.format(date);

			String parte_2_codigo = Long.toHexString(idCliente);

			String parte_3_codigo = idProducto + "";

			String codigo = parte_3_codigo + "-" + parte_2_codigo + "-" + parte_1_codigo;

			Map<String, Integer> mapOutVariables = SolicitudCreditoDAO.GenerarSolicitudCreditoCliente(idCliente,
					idFuncionario, idProducto, codigo);

			if (mapOutVariables != null) {

				int idEstadoCredito = mapOutVariables.get("idEstadoCredito");
				if (this.estadoCreditoService.getExistEstadoCredito(idEstadoCredito)) {

					EstadoCredito estadoC = this.estadoCreditoService.getEstadoCredito(idEstadoCredito);
					SolicitudCredito sol = this.solicitudRep.findBycodigoCredito(codigo).orElseThrow();
					this.solicitudRep.EnlazarEstadoSolicitud(sol.getIdSolicitudCredito(), estadoC.getIdEstadoCredito());

					sol.setEstado(estadoC);

					return this.solicitudMapper.toDto(sol);

				} else {
					throw new SolicitudCreditoException("No se pudo generar la solicitud de credito");
				}

			} else {

				throw new SolicitudCreditoException("No se pudo generar la solicitud de credito");

			}

		}

		throw new NoSuchElementException();

	}

}
