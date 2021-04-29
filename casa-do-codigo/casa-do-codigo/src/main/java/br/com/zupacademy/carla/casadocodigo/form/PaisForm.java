package br.com.zupacademy.carla.casadocodigo.form;

import javax.validation.constraints.NotNull;

import br.com.zupacademy.carla.casadocodigo.anotacao.UniqueValue;
import br.com.zupacademy.carla.casadocodigo.modelo.Pais;


public class PaisForm {

	@UniqueValue(domainClass = Pais.class, fieldName="nome")
	@NotNull
	private String nome;
	
	
	public PaisForm(@NotNull String nome) {
		this.nome = nome;
	}
	 
	public PaisForm() {
		
	}
	

	public String getNome() {
		return nome;
	}

	
	
	
	public Pais converter() {
		return new Pais(nome);
	}
	
}
