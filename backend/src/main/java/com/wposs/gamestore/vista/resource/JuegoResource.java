package com.wposs.gamestore.vista.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wposs.gamestore.modelo.Juego;
import com.wposs.gamestore.modelo.Tecnologia;
import com.wposs.gamestore.negocio.service.JuegoService;
import com.wposs.gamestore.negocio.service.TecnologiaService;
import com.wposs.gamestore.vista.resource.vo.JuegoVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "http://localhost:8100")
@RestController
@RequestMapping("/api/juego")
@Api(tags = "juego")
public class JuegoResource {

	private final JuegoService juegoService;
	private final TecnologiaService tecnologiaService;

	
	public JuegoResource(JuegoService juegoService, TecnologiaService tecnologiaService) {
		this.juegoService = juegoService;
		this.tecnologiaService = tecnologiaService;
	}

	@PostMapping
	@ApiOperation(value = "Crear un juego", notes = "Servicio para crear un nuevo juego")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Juego creado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Invalida")})
	public ResponseEntity<Juego> createJuego(@Valid @RequestBody JuegoVO juegoVO) {
		Juego juego = new Juego();
		Tecnologia tecnologia = new Tecnologia();
			
		tecnologia = this.tecnologiaService.findByIdTec(juegoVO.getIdTecnologia());
		
		juego.setDirectorJue(juegoVO.getDirectorJue());
		juego.setMarcaJue(juegoVO.getMarcaJue());
		juego.setNombreJue(juegoVO.getNombreJue());
		juego.setPrecioJue(juegoVO.getPrecioJue());
		juego.setProductorJue(juegoVO.getProductorJue());
		juego.setProtagonistaJue(juegoVO.getProtagonistaJue());
		juego.setTecnologia(tecnologia);
		
		return new ResponseEntity<>(this.juegoService.create(juego), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Actualizar un juego", notes = "Servicio para actualizar un juego")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Juego actualizado correctamente"),
			@ApiResponse(code = 404, message = "Juego no encontrado")})
	public ResponseEntity<Juego> updateCliente(@PathVariable("id") Integer id, @Valid @RequestBody JuegoVO juegoVO) {

		Juego juegoOLD = this.juegoService.findById(id);
		Tecnologia tecnologia = new Tecnologia();
		
		tecnologia = this.tecnologiaService.findByIdTec(juegoVO.getIdTecnologia());
		
		if (juegoOLD == null) {
			return new ResponseEntity<Juego>(HttpStatus.NOT_FOUND);
		} else {
			juegoOLD.setDirectorJue(juegoVO.getDirectorJue());
			juegoOLD.setMarcaJue(juegoVO.getMarcaJue());
			juegoOLD.setNombreJue(juegoVO.getNombreJue());
			juegoOLD.setPrecioJue(juegoVO.getPrecioJue());
			juegoOLD.setProductorJue(juegoVO.getProductorJue());
			juegoOLD.setProtagonistaJue(juegoVO.getProtagonistaJue());
			juegoOLD.setTecnologia(tecnologia);
			return new ResponseEntity<>(this.juegoService.create(juegoOLD), HttpStatus.CREATED);
		}

	}
	
	@GetMapping
	@ApiOperation(value = "Listar juegos", notes = "Servicio para listar todos los juegos")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Juegos encontrados"),
			@ApiResponse(code = 404, message = "Juegos no encontrados")})
	public ResponseEntity<List<Juego>> findAll(){
		return ResponseEntity.ok(this.juegoService.findAll());
	}
	
	@GetMapping("/{nombre}")
	@ApiOperation(value = "Listar un juego", notes = "Servicio para listar un juego")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Juego encontrado"),
			@ApiResponse(code = 404, message = "Juego no encontrado")})
	public ResponseEntity<Juego> find(@PathVariable("nombre") String nombre){
		Juego juego = this.juegoService.findByNombre(nombre);
		if (juego == null) {
			return new ResponseEntity<Juego>(HttpStatus.NOT_FOUND);
		} else {
			return ResponseEntity.ok(juego);			
		}
	}
	
	@GetMapping("/{id}/show")
	@ApiOperation(value = "Listar un juego por id", notes = "Servicio para listar un juego por id")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Juego encontrado"),
			@ApiResponse(code = 404, message = "Juego no encontrado")})
	public ResponseEntity<Juego> find(@PathVariable("id") Integer id){
		Juego juego = this.juegoService.findById(id);
		if (juego == null) {
			return new ResponseEntity<Juego>(HttpStatus.NOT_FOUND);
		} else {
			return ResponseEntity.ok(juego);			
		}
	}
	
}
