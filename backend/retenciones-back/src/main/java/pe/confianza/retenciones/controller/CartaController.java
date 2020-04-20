package pe.confianza.retenciones.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import pe.confianza.retenciones.modelo.Cartas;
import pe.confianza.retenciones.service.ICartaService;

@RestController
@RequestMapping("/carta")
public class CartaController {
	@Autowired
	private ICartaService service;
	
	@PostMapping //save
	public ResponseEntity<Object> registrar(@Valid @RequestBody Cartas obj){
		Cartas cartas = service.registrar(obj);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cartas.getIdCarta()).toUri();
		return ResponseEntity.created(location).build();
	}
	//@PutMapping //upd
	//@DeleteMapping //delete
	//@GetMapping //listar
}
