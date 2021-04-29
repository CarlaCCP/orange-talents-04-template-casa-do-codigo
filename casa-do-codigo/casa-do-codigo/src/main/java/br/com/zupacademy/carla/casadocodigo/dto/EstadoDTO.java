package br.com.zupacademy.carla.casadocodigo.dto;

import br.com.zupacademy.carla.casadocodigo.modelo.Estado;

public class EstadoDTO {

	private Long id;
	private String nome;
	private Long idPais;
	
	
	public EstadoDTO(Estado estado) {
		
		this.id = estado.getId();
		this.nome = estado.getNome();
		this.idPais = estado.getPais().getId();
	}
	
	public EstadoDTO () {
		
	}


	public Long getId() {
		return id;
	}


	public String getNome() {
		return nome;
	}

	public Long getIdPais() {
		return idPais;
	}





	
}
