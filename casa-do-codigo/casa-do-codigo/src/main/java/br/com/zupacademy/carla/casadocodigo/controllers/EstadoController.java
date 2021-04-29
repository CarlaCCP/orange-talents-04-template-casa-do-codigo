package br.com.zupacademy.carla.casadocodigo.controllers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.carla.casadocodigo.dto.EstadoDTO;
import br.com.zupacademy.carla.casadocodigo.form.EstadoForm;
import br.com.zupacademy.carla.casadocodigo.modelo.Estado;
import br.com.zupacademy.carla.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.carla.casadocodigo.repository.PaisRepository;

@RestController
@RequestMapping("/estado")
public class EstadoController {
	
	@PersistenceContext
	private EntityManager manager;

	@Autowired
	private EstadoRepository repository;
	
	@Autowired
	private PaisRepository paisRepository; 
	
	@PostMapping
	public ResponseEntity<EstadoDTO> cadastrar (@RequestBody @Valid EstadoForm form){
		Estado estado = form.converter(manager);
		
		repository.save(estado);
		return ResponseEntity.ok(new EstadoDTO(estado));
	}
}
