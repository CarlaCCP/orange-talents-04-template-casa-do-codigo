package br.com.zupacademy.carla.casadocodigo.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import br.com.zupacademy.carla.casadocodigo.modelo.Autor;

public class AutorDTO {

	private Long id;
	private LocalDateTime instante = LocalDateTime.now();
	private String email;
	private String descricao;
	private String nome;
	
	public AutorDTO() {
		
	}
	
	public AutorDTO (Autor autor) {
		this.id = autor.getId();
		this.descricao = autor.getDescricao();
		this.instante = autor.getInstante();
		this.email = autor.getEmail();
		this.nome = autor.getNome();
	}

	public Long getId() {
		return id;
	}

	public LocalDateTime getInstante() {
		return instante;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public String getNome() {
		return nome;
	}
	
	public static List<AutorDTO> converter(List<Autor> autor) {
		return autor.stream().map(AutorDTO::new).collect(Collectors.toList());
	}
	
}
