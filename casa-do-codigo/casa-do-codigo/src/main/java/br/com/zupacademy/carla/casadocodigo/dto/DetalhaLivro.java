package br.com.zupacademy.carla.casadocodigo.dto;

import br.com.zupacademy.carla.casadocodigo.modelo.novoLivro;

public class DetalhaLivro {

	private String titulo;
	private String resumo;
	private String sumario;
	private Double preco;
	private int numeroPaginas;
	private String isbn;
	private String nomeAutor;
	private String categoria;
	
	
	public DetalhaLivro (novoLivro livro) {
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.numeroPaginas = livro.getNumeroPaginas();
		this.isbn = livro.getIsbn();
		this.nomeAutor = livro.getAutor().getNome();
		this.categoria = livro.getCategoria().getNome();
	}


	public String getTitulo() {
		return titulo;
	}


	public String getResumo() {
		return resumo;
	}


	public String getSumario() {
		return sumario;
	}


	public Double getPreco() {
		return preco;
	}


	public int getNumeroPaginas() {
		return numeroPaginas;
	}


	public String getIsbn() {
		return isbn;
	}


	public String getNomeAutor() {
		return nomeAutor;
	}


	public String getCategoria() {
		return categoria;
	}
	
	
	
}
