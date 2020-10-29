package com.wposs.gamestore.vista.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wposs.gamestore.modelo.Cliente;
import com.wposs.gamestore.negocio.service.ClienteService;
import com.wposs.gamestore.vista.resource.vo.ClienteVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "http://localhost:8100")
@RestController
@RequestMapping("/api/cliente")
@Api(tags = "cliente")
public class ClienteResource {

	private final ClienteService clienteService;

	public ClienteResource(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@PostMapping
	@ApiOperation(value = "Crear un cliente", notes = "Servicio para crear un nuevo cliente")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Cliente creado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Invalida")})
	public ResponseEntity<Cliente> createCliente(@Valid @RequestBody ClienteVO clienteVO) {
		Cliente cliente = new Cliente();
		cliente.setDocumentoCli(clienteVO.getDocumento());
		cliente.setFechaNacimientoCli(clienteVO.getFechaNacimiento());
		cliente.setNombreCli(clienteVO.getNombre());
		cliente.setTelefonoCli(clienteVO.getTelefono());

		return new ResponseEntity<>(this.clienteService.create(cliente), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Actualizar un cliente", notes = "Servicio para actualizar un cliente")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Cliente actualizado correctamente"),
			@ApiResponse(code = 404, message = "Cliente no encontrado")})
	public ResponseEntity<Cliente> updateCliente(@PathVariable("id") Integer id, ClienteVO clienteVO) {

		Cliente cliente = this.clienteService.findById(id);
		if (cliente == null) {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		} else {
			cliente.setDocumentoCli(clienteVO.getDocumento());
			cliente.setFechaNacimientoCli(clienteVO.getFechaNacimiento());
			cliente.setNombreCli(clienteVO.getNombre());
			cliente.setTelefonoCli(clienteVO.getTelefono());
		}

		return new ResponseEntity<>(this.clienteService.create(cliente), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Eliminar un cliente", notes = "Servicio para eliminar un cliente")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Cliente eliminado correctamente"),
			@ApiResponse(code = 404, message = "Cliente no encontrado")})
	public void removeCliente(@PathVariable("id") Integer id) {
		Cliente cliente = this.clienteService.findById(id);
		if (cliente != null) {
			this.clienteService.delete(cliente);
		}
	}
	
	@GetMapping
	@ApiOperation(value = "Listar clientes", notes = "Servicio para listar todos los clientes")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Clientes encontrados"),
			@ApiResponse(code = 404, message = "Clientes no encontrados")})
	public ResponseEntity<List<Cliente>> findAll(){
		return ResponseEntity.ok(this.clienteService.findAll());
	}
	
	@GetMapping("/{documento}")
	@ApiOperation(value = "Listar un cliente", notes = "Servicio para listar un cliente")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Clientes encontrado"),
			@ApiResponse(code = 404, message = "Clientes no encontrados")})
	public ResponseEntity<Cliente> find(@PathVariable("documento") String documento){
		Cliente cliente = this.clienteService.findByDocumento(documento);
		if (cliente == null) {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		} else {
			return ResponseEntity.ok(cliente);			
		}
	}
}
