package com.wposs.gamestore.vista.resource;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wposs.gamestore.modelo.Alquiler;
import com.wposs.gamestore.negocio.service.AlquilerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/alquiler")
@Api(tags = "alquiler")
public class AlquilerResource {

	private final AlquilerService alquilerService;

	public AlquilerResource(AlquilerService alquilerService) {
		this.alquilerService = alquilerService;
	}
	
	@PostMapping
	@ApiOperation(value = "Alquilar un juego", notes = "Servicio para alquilar un nuevo juego")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Juego creado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Invalida")})
	public ResponseEntity<Alquiler> createAlquiler(@RequestBody Alquiler alquiler) {
		return new ResponseEntity<>(this.alquilerService.create(alquiler), HttpStatus.CREATED);
	}

	@PutMapping("/{id}/entregar")
	@ApiOperation(value = "Entregar un juego", notes = "Servicio para entregar un juego")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Juego entregado correctamente"),
			@ApiResponse(code = 404, message = "Juego no encontrado")})
	public ResponseEntity<Alquiler> updateAlquiler(@PathVariable("id") Integer id, Alquiler alquiler) {

		Alquiler alquilerOLD = this.alquilerService.find(id);
		if (alquilerOLD == null) {
			return new ResponseEntity<Alquiler>(HttpStatus.NOT_FOUND);
		} else {
			alquilerOLD.setFechaEntregaAlq(new Date());
			return new ResponseEntity<>(this.alquilerService.create(alquilerOLD), HttpStatus.CREATED);
		}

	}
	
}
