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

import br.com.zupacademy.carla.casadocodigo.dto.ClienteDTO;
import br.com.zupacademy.carla.casadocodigo.modelo.Cliente;
import br.com.zupacademy.carla.casadocodigo.form.ClienteForm;
import br.com.zupacademy.carla.casadocodigo.repository.ClienteRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository repository;

	@PersistenceContext
	private EntityManager manager;

	@PostMapping
	public ResponseEntity<ClienteDTO> cadastrar(@RequestBody @Valid ClienteForm form) {

		Cliente cliente = form.converter(manager);
		repository.save(cliente);
		return ResponseEntity.ok(new ClienteDTO(cliente));

	}
}
