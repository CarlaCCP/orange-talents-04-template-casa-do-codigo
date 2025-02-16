package br.com.zupacademy.carla.casadocodigo.modelo;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.carla.casadocodigo.anotacao.UniqueValue;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	//@UniqueValue(domainClass = Categoria.class, fieldName="nome")
	private String nome;

	public Categoria () {
		
	}
	
	public Categoria (String nome) {
	
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public Long getId() {

		return id;
	}
	
	
}
