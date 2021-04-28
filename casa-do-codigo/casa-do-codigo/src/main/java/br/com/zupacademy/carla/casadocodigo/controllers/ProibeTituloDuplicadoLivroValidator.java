package br.com.zupacademy.carla.casadocodigo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.carla.casadocodigo.form.novoLivroForm;
import br.com.zupacademy.carla.casadocodigo.modelo.novoLivro;
import br.com.zupacademy.carla.casadocodigo.repository.novoLivroRepository;

@Component
public class ProibeTituloDuplicadoLivroValidator implements Validator{

	@Autowired
	private novoLivroRepository repository;
	
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return novoLivroForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		novoLivroForm form = (novoLivroForm) target;
		Optional<novoLivro> possivelLivro = repository.findByTitulo(form.getTitulo());
		
		if(possivelLivro.isPresent()) {
			errors.rejectValue("titulo", null, "Já existe esse titulo cadastrado anteriormente");
		}
	}

}
