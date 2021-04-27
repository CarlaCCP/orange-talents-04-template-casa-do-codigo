package br.com.zupacademy.carla.casadocodigo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import br.com.zupacademy.carla.casadocodigo.form.AutorForm;
import br.com.zupacademy.carla.casadocodigo.modelo.Autor;
import br.com.zupacademy.carla.casadocodigo.repository.AutorRepository;

@Component
public class ProibeEmailDuplicadoAutorValidator implements Validator{

	@Autowired
	private AutorRepository repository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return AutorForm.class.isAssignableFrom(clazz); // se a classe que esta chegando é de novoAutor ou é filha
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) { // se encontrar algum erro antes da validacao do email, ele ja para
			return;
		}
		
		AutorForm form = (AutorForm) target;
		Optional <Autor> possivelAutor = repository.findByEmail(form.getEmail());
		
		if (possivelAutor.isPresent()) {
			errors.rejectValue("email", null, "Ja existe um autor com o mesmo email " + form.getEmail());
		}
	}

	

	
}
