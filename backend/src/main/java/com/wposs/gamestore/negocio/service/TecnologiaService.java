package com.wposs.gamestore.negocio.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wposs.gamestore.modelo.Tecnologia;
import com.wposs.gamestore.negocio.repository.TecnologiaRepository;

@Service
@Transactional(readOnly = true)
public class TecnologiaService {
	
	private final TecnologiaRepository tecnologiaRepository;

	public TecnologiaService(TecnologiaRepository tecnologiaRepository) {
		this.tecnologiaRepository = tecnologiaRepository;
	}
	
	@Transactional
	public Tecnologia create(Tecnologia tecnologia) {
		return this.tecnologiaRepository.save(tecnologia);
	}

	public List<Tecnologia> findAll() {
		return this.tecnologiaRepository.findAll();
	}

	public Tecnologia findByIdTec(Integer id) {
		return this.tecnologiaRepository.findByidTec(id);
	}
	

}
