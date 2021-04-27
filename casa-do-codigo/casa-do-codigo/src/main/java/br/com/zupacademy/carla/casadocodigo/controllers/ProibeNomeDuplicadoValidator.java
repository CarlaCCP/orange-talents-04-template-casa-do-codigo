package br.com.zupacademy.carla.casadocodigo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.carla.casadocodigo.form.CategoriaForm;
import br.com.zupacademy.carla.casadocodigo.modelo.Categoria;
import br.com.zupacademy.carla.casadocodigo.repository.CategoriaRepository;

@Component
public class ProibeNomeDuplicadoValidator implements Validator {

	@Autowired
	private CategoriaRepository repository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return CategoriaForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		
		CategoriaForm form = (CategoriaForm) target;
		Optional<Categoria> possivelCategoria = repository.findByNome(form.getNome());
		
	if (possivelCategoria.isPresent()) {
		errors.rejectValue("nome", null, "Já existe um categoria com o nome " + form.getNome());
	}
		
	}

}
