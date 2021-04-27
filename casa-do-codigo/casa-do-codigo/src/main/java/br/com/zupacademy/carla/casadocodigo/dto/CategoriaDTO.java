package br.com.zupacademy.carla.casadocodigo.dto;

import br.com.zupacademy.carla.casadocodigo.modelo.Categoria;

public class CategoriaDTO {

	private Long id;
	private String nome;
	
	public CategoriaDTO() {
		
	}
	
	public CategoriaDTO(Categoria categoria) {
		this.id = categoria.getId();
		this.nome = categoria.getNome();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	
}
