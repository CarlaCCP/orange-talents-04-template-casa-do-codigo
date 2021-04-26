package br.com.zupacademy.carla.casadocodigo.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zupacademy.carla.casadocodigo.modelo.Autor;
import br.com.zupacademy.carla.casadocodigo.repository.AutorRepository;

public class AutorForm {

	@NotNull
	//@Email(message = "Email precisa ser valido")
	private String email;

	@NotNull
	@Size(max = 400)
	private String descricao;
	
	@NotNull
	private String nome;

	public AutorForm(String descricao, String email, String nome) {
		this.descricao = descricao;
		this.email = email;
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	public Autor converter(AutorRepository repository) {

		Autor autor = new Autor(descricao, email, nome);
		return autor;
	}

}
