package br.com.zupacademy.carla.casadocodigo.dto;


import java.util.Date;
import java.util.List;

import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;


import br.com.zupacademy.carla.casadocodigo.modelo.novoLivro;

public class novoLivroDTO {

	private Long id; 
	

	private String titulo;

	private String resumo;
	
	private String sumario;
	

	private Double preco;
	

	private int numeroPaginas;
	

	
	private Date dataPublicao;
	
	
	private String isbn;
	
	private Long idCategoria;
	
	private Long idAutor;

	public novoLivroDTO(novoLivro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.numeroPaginas = livro.getNumeroPaginas();
		this.dataPublicao = livro.getDataPublicao();
		this.isbn = livro.getIsbn();
	
	}
	
	public novoLivroDTO() {
		
	}
	
	public Long getId() {
		return id;
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


	public Date getDataPublicao() {
		return dataPublicao;
	}


	public String getIsbn() {
		return isbn;
	}



	public Long getIdCategoria() {
		return idCategoria;
	}

	
	public Long getIdAutor() {
		return idAutor;
	}

	public static List<novoLivroDTO> converter(List<novoLivro> livro){
		return livro.stream().map(novoLivroDTO::new)
				.collect(Collectors.toList());
	}
	
}
