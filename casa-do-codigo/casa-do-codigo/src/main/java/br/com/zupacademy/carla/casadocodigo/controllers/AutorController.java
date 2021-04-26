package br.com.zupacademy.carla.casadocodigo.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zupacademy.carla.casadocodigo.dto.AutorDTO;
import br.com.zupacademy.carla.casadocodigo.form.AutorForm;
import br.com.zupacademy.carla.casadocodigo.modelo.Autor;
import br.com.zupacademy.carla.casadocodigo.repository.AutorRepository;

@RestController
@RequestMapping("/autor")
public class AutorController {

	@Autowired
	private AutorRepository autorRepository;
	
	@PostMapping
	public ResponseEntity<AutorDTO> cadastra (@RequestBody @Valid AutorForm form,
			UriComponentsBuilder uriBuilder){
		
		Autor autor = form.converter(autorRepository);
		autorRepository.save(autor);
		
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(autor.getId()).toUri();
		return ResponseEntity.created(uri).body(new AutorDTO(autor));
	}
}
