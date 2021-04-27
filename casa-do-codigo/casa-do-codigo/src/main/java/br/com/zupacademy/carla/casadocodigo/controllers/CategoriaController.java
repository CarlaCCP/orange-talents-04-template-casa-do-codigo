package br.com.zupacademy.carla.casadocodigo.controllers;

import javax.validation.Valid;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.util.UriComponentsBuilder;

import br.com.zupacademy.carla.casadocodigo.dto.CategoriaDTO;
import br.com.zupacademy.carla.casadocodigo.form.CategoriaForm;
import br.com.zupacademy.carla.casadocodigo.modelo.Categoria;
import br.com.zupacademy.carla.casadocodigo.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaRepository repository;
	
	@Autowired
	private ProibeNomeDuplicadoValidator proibeNomeDuplicado; 
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(proibeNomeDuplicado);
	}
	
	@PostMapping
	public ResponseEntity<CategoriaDTO> cadastrar (@RequestBody @Valid CategoriaForm form, 
			UriComponentsBuilder uriBuilder){
		Categoria categoria = form.converter(repository);
		repository.save(categoria);
		URI uri = uriBuilder.path("/categoria/{id}").buildAndExpand(categoria.getId()).toUri();
		return ResponseEntity.created(uri).body(new CategoriaDTO(categoria));
	}
}
