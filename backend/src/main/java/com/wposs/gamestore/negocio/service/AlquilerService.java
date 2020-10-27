package com.wposs.gamestore.negocio.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wposs.gamestore.modelo.Alquiler;
import com.wposs.gamestore.negocio.repository.AlquilerRepository;

@Service
@Transactional(readOnly = true)
public class AlquilerService {
	
	private final AlquilerRepository alquilerRepository;

	public AlquilerService(AlquilerRepository alquilerRepository) {
		this.alquilerRepository = alquilerRepository;
	}
	
	/**
	 * Almacenar un alquiler
	 * @param alquiler
	 * @return
	 */
	@Transactional
	public Alquiler create(Alquiler alquiler) {
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
