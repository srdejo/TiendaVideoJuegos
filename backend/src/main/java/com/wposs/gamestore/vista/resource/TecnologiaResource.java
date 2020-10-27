package com.wposs.gamestore.vista.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wposs.gamestore.modelo.Tecnologia;
import com.wposs.gamestore.negocio.service.TecnologiaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/tecnologia")
@Api(tags = "tecnologia")
public class TecnologiaResource {

	private final TecnologiaService tecnologiaService;

	public TecnologiaResource(TecnologiaService tecnologiaService) {
		this.tecnologiaService = tecnologiaService;
	}
	
	@PostMapping
	@ApiOperation(value = "Crear una tecnologia o consola de juego", notes = "Servicio para crear una tecnologia o consola de juego")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Tecnología creado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Invalida")})
	public ResponseEntity<Tecnologia> createTecnologia(@RequestBody Tecnologia tecnologia) {
		return new ResponseEntity<>(this.tecnologiaService.create(tecnologia), HttpStatus.CREATED);
	}
	
	@GetMapping
	@ApiOperation(value = "Listar tecnologias", notes = "Servicio para listar todos las tecnologias")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Tecnologias encontradas"),
			@ApiResponse(code = 404, message = "Tecnologias no encontrados")})
	public ResponseEntity<List<Tecnologia>> findAll(){
		return ResponseEntity.ok(this.tecnologiaService.findAll());
	}
}
