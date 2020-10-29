package com.wposs.gamestore.negocio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wposs.gamestore.modelo.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	Cliente findByDocumentoCli(String documentoCli);

	Cliente findByIdCli(Integer id);

}
