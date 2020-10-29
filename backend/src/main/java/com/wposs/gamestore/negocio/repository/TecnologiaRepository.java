package com.wposs.gamestore.negocio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wposs.gamestore.modelo.Tecnologia;

public interface TecnologiaRepository extends JpaRepository<Tecnologia, Integer>{

	Tecnologia findByidTec(Integer id);

}
