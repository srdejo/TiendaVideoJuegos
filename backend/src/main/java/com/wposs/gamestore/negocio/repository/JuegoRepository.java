package com.wposs.gamestore.negocio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wposs.gamestore.modelo.Juego;

public interface JuegoRepository extends JpaRepository<Juego, Integer>{

	Juego findByNombreJue(String nombre);

	Juego findByIdJue(Integer id);
}
