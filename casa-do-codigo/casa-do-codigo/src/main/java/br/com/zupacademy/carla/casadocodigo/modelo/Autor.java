package br.com.zupacademy.carla.casadocodigo.modelo;

import java.time.LocalDateTime; 

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private LocalDateTime instante = LocalDateTime.now();
	@NotNull
	//@Email(message= "Email precisa ser valido")
	private String email;
	@NotNull
	@Size(max=400)
	private String descricao;
	
	@NotNull
	private String nome; 
	
	
	public Autor (String email, String descricao, String nome) {
	
		this.email = email;
		this.descricao = descricao;
		this.nome = nome;
	}
	
	public Autor() {
		
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


}
