package br.com.zupacademy.carla.casadocodigo.form;

import javax.validation.constraints.NotNull;

import br.com.zupacademy.carla.casadocodigo.modelo.Categoria;
import br.com.zupacademy.carla.casadocodigo.repository.CategoriaRepository;

public class CategoriaForm {

	@NotNull
	private String nome;
	
	public CategoriaForm() {
		
	}
	
	public CategoriaForm(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
	public Categoria converter (CategoriaRepository repository) {
		Categoria categoria = new Categoria(nome);
		return categoria;
	}
}
