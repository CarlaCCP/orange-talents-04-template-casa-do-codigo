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

import br.com.zupacademy.carla.casadocodigo.dto.PaisDTO;
import br.com.zupacademy.carla.casadocodigo.form.PaisForm;
import br.com.zupacademy.carla.casadocodigo.modelo.Pais;
import br.com.zupacademy.carla.casadocodigo.repository.PaisRepository;

@RestController
@RequestMapping("/pais")
public class PaisController {
	
	
	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private PaisRepository repository;

	@PostMapping
	public ResponseEntity<PaisDTO> cadastrar(@RequestBody @Valid PaisForm form){
		Pais pais = form.converter();
		repository.save(pais);
		return ResponseEntity.ok(new PaisDTO(pais));
		
	}
}
