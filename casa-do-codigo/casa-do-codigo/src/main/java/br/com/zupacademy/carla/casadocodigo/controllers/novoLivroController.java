package br.com.zupacademy.carla.casadocodigo.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zupacademy.carla.casadocodigo.dto.DetalhaLivro;
import br.com.zupacademy.carla.casadocodigo.dto.ItemListaLivro;
import br.com.zupacademy.carla.casadocodigo.dto.novoLivroDTO;
import br.com.zupacademy.carla.casadocodigo.form.novoLivroForm;
import br.com.zupacademy.carla.casadocodigo.modelo.novoLivro;
import br.com.zupacademy.carla.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.carla.casadocodigo.repository.novoLivroRepository;

@RestController
@RequestMapping("/livro")
public class novoLivroController {

	@Autowired
	private novoLivroRepository repository;

	@Autowired
	private ProibeTituloDuplicadoLivroValidator proibeTituloDuplicadoLivroValidator;

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private ProibeISBNDuplicadoLivroValidator proibeISBNDuplicadoLivroValidator;

	@InitBinder
	public void init(WebDataBinder binder) {

		binder.addValidators(proibeTituloDuplicadoLivroValidator);
		binder.addValidators(proibeISBNDuplicadoLivroValidator);
	}

	@PostMapping
	public ResponseEntity<novoLivroDTO> cadastra(@RequestBody @Valid novoLivroForm form,
			UriComponentsBuilder uriBuilder) {

		novoLivro livro = form.converter(em);

		repository.save(livro);

		URI uri = uriBuilder.path("/livro/{id}").buildAndExpand(livro.getId()).toUri();

		return ResponseEntity.ok(new novoLivroDTO(livro));
	}

	@GetMapping
	public List<ItemListaLivro> GetAll() {
		List<novoLivro> livro = repository.findAll();

		return ItemListaLivro.converter(livro);
	}

	@GetMapping("/{id}")
	public ResponseEntity<DetalhaLivro> listar(@PathVariable Long id) {
		Optional<novoLivro> livro = repository.findById(id);
		if (livro.isPresent()) {
			return ResponseEntity.ok(new DetalhaLivro(livro.get()));
		}

		return ResponseEntity.notFound().build();
	}

}
