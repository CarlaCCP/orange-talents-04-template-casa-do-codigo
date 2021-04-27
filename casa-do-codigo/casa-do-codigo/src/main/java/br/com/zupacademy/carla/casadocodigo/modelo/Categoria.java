package br.com.zupacademy.carla.casadocodigo.modelo;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String nome;

	@Deprecated
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
