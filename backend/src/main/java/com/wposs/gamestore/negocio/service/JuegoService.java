package com.wposs.gamestore.negocio.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wposs.gamestore.modelo.Juego;
import com.wposs.gamestore.negocio.repository.JuegoRepository;

@Service
@Transactional(readOnly = true)
public class JuegoService {

	private final JuegoRepository juegoRepository;

	public JuegoService(JuegoRepository juegoRepository) {
		this.juegoRepository = juegoRepository;
	}
	
	/**
	 * Almacenar un juego
	 * @param juego
	 * @return
	 */
	@Transactional
	public Juego create(Juego juego) {
		return this.juegoRepository.save(juego);
	}
	
	/**
	 * Almacenar un juego
	 * @param juego
	 * @return
	 */
	@Transactional
	public Juego update(Juego juego) {
		return this.juegoRepository.save(juego);
	}

	/**
	 * Buscar un juego por nombre
	 * @param nombre
	 * @return
	 */
	public Juego findByNombre(String nombre) {
		return this.juegoRepository.findByNombreJue(nombre);
	}


	/**
	 * Obtener todos los juegos
	 * @return
	 */
	public List<Juego> findAll() {
		return this.juegoRepository.findAll();
	}

	public Juego findById(Integer id) {
		return this.juegoRepository.findByIdJue(id);
	}

	
}
