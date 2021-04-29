package br.com.zupacademy.carla.casadocodigo.form;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.carla.casadocodigo.anotacao.ExistsId;
import br.com.zupacademy.carla.casadocodigo.anotacao.UniqueValue;
import br.com.zupacademy.carla.casadocodigo.modelo.Estado;
import br.com.zupacademy.carla.casadocodigo.modelo.Pais;

public class EstadoForm {
	
	
	@UniqueValue(domainClass = Estado.class, fieldName="nome")
	@NotNull
	private String nome;
	
	@NotNull
	@ExistsId(domainClass = Pais.class, fieldName = "id")
	private Long idPais;
	
	public EstadoForm(@NotNull String nome, @NotNull Long idPais) {
		this.nome = nome;
		this.idPais = idPais;
	}
	
	public Estado converter(EntityManager manager) {
		Pais pais = manager.find(Pais.class, idPais);
	
		//Estado estado = estadoRepository.findByPais_Nome(nomePais);
		return new Estado(nome, pais);
	}
}
