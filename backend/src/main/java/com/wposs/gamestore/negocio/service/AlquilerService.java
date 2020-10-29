package com.wposs.gamestore.negocio.service;

import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wposs.gamestore.modelo.Alquiler;
import com.wposs.gamestore.modelo.Cliente;
import com.wposs.gamestore.modelo.Juego;
import com.wposs.gamestore.negocio.repository.AlquilerRepository;
import com.wposs.gamestore.vista.resource.vo.AlquilerVO;

@Service
@Transactional(readOnly = true)
public class AlquilerService {
	
	private final AlquilerRepository alquilerRepository;
	private final ClienteService clienteService;
	private final JuegoService juegoService;

	
	public AlquilerService(AlquilerRepository alquilerRepository, ClienteService clienteService,
			JuegoService juegoService) {
		
		this.alquilerRepository = alquilerRepository;
		this.clienteService = clienteService;
		this.juegoService = juegoService;
	}

	/**
	 * Almacenar un alquiler
	 * @param alquiler
	 * @return
	 */
	@Transactional
	public Alquiler create(AlquilerVO alquilerVO) {
		Cliente cliente = new Cliente();
		Juego juego = new Juego();
		Alquiler alquiler = new Alquiler();
		
		cliente = this.clienteService.findById(alquilerVO.getIdCliente());
		juego = this.juegoService.findById(alquilerVO.getIdJuego());
		
		alquiler.setCliente(cliente);
		alquiler.setJuego(juego);
		alquiler.setFechaAlq(new Date());
		
		return this.alquilerRepository.save(alquiler);
	}
		
	@Transactional
	public Alquiler update(Alquiler alquiler) {
		return this.alquilerRepository.save(alquiler);
	}
	
	
	public Alquiler find(Integer id) {
		return this.alquilerRepository.getOne(id);
	}

}
