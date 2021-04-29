package br.com.zupacademy.carla.casadocodigo.dto;

import java.util.List;

import java.util.stream.Collectors;

import br.com.zupacademy.carla.casadocodigo.modelo.novoLivro;

public class ItemListaLivro {

	private Long id;
	private String nome;
	
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	
	public ItemListaLivro(novoLivro livro) {
		this.id = livro.getId();
		this.nome = livro.getTitulo();
	}
	
	
	public static List<ItemListaLivro> converter (List<novoLivro> livro){
		return livro.stream().map(ItemListaLivro::new)
				.collect(Collectors.toList());
	}
}
