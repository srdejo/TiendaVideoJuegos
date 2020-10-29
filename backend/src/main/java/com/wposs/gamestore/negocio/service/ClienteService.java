package com.wposs.gamestore.negocio.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wposs.gamestore.modelo.Cliente;
import com.wposs.gamestore.negocio.repository.ClienteRepository;

@Service
@Transactional(readOnly = true)
public class ClienteService {

	private final ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	/**
	 * Guardar cliente
	 * @param cliente
	 * @return
	 */
	@Transactional
	public Cliente create(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}
	
	/**
	 * Actualizar cliente
	 * @param cliente
	 * @return
	 */
	@Transactional
	public Cliente update(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}
	
	/**
	 * Eliminar un cliente
	 * @param cliente
	 */
	@Transactional
	public void delete(Cliente cliente) {
		this.clienteRepository.delete(cliente);
	}

	public Cliente findByDocumento(String documentoCli) {
		return this.clienteRepository.findByDocumentoCli(documentoCli);
	}

	public List<Cliente> findAll() {
		return this.clienteRepository.findAll();
	}

	public Cliente findById(Integer id) {
		return this.clienteRepository.findByIdCli(id);
	}
	
}
