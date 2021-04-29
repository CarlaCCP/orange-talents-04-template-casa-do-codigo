package br.com.zupacademy.carla.casadocodigo.form;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.carla.casadocodigo.anotacao.UniqueValue;
import br.com.zupacademy.carla.casadocodigo.modelo.Cliente;
import br.com.zupacademy.carla.casadocodigo.modelo.Estado;
import br.com.zupacademy.carla.casadocodigo.modelo.Pais;

public class ClienteForm {

	@NotBlank
	@Email
	@UniqueValue(domainClass = Cliente.class, fieldName = "email")
	private String email; // unico
	@NotBlank
	private String nome; 
	@NotBlank
	private String sobrenome;
	@NotBlank
	@UniqueValue(domainClass = Cliente.class, fieldName = "documento")
	private String documento; // unico
	@NotBlank
	private String endereco;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cidade;
	@NotNull
	private Long  idPais;
	@NotNull
	private Long idEstado;
	@NotBlank
	private String telefone;
	@NotBlank
	private String cep;
	
	public ClienteForm() {
		
	}

	public ClienteForm(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome, @NotBlank String documento,
			@NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade, @NotNull Long idPais,
			@NotNull Long idEstado, @NotBlank String telefone, @NotBlank String cep) {
		super();
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.idPais = idPais;
		this.idEstado = idEstado;
		this.telefone = telefone;
		this.cep = cep;
	}

	public String getEmail() {
		return email;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public Long getIdPais() {
		return idPais;
	}

	public Long getIdEstado() {
		return idEstado;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}
	
	
	public String getNome() {
		return nome;
	}

	public Cliente converter (EntityManager manager) {
		Pais pais = manager.find(Pais.class, idPais);
		Estado estado = manager.find(Estado.class, this.idEstado);
		
		return new Cliente (email, nome, sobrenome, documento,
				endereco, complemento,cidade, pais, estado,telefone, cep);
	}
}
