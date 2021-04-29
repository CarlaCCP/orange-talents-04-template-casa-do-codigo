package br.com.zupacademy.carla.casadocodigo.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.carla.casadocodigo.anotacao.UniqueValue;

@Entity
public class Pais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//@UniqueValue(domainClass = Pais.class, fieldName="nome")
	@NotNull
	private String nome;
	
	
	public Pais(@NotNull String nome) {
		this.nome = nome;
		
	}
	
	public Pais () {
		
	}
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	
	
	
	
}
