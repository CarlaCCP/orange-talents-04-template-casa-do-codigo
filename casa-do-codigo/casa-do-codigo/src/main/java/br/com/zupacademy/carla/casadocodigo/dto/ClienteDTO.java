package br.com.zupacademy.carla.casadocodigo.dto;

import br.com.zupacademy.carla.casadocodigo.modelo.Cliente;

public class ClienteDTO {

	private String email; // unico
	private String nome;
	private String sobrenome;
	private String documento; // unico
	private String endereco;
	private String complemento;
	private String cidade;
	private Long  idPais;
	private Long idEstado;
	private String telefone;
	private String cep;
	
	


	public ClienteDTO(Cliente cliente) {
		super();
		this.email = cliente.getEmail();
		this.nome = cliente.getNome();
		this.sobrenome = cliente.getSobrenome();
		this.documento = cliente.getDocumento();
		this.endereco = cliente.getEndereco();
		this.complemento = cliente.getComplemento();
		this.cidade = cliente.getCidade();
		this.idPais = cliente.getPais().getId();
		this.idEstado = cliente.getEstado().getId();
		this.telefone = cliente.getTelefone();
		this.cep = cliente.getCep();
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
	
	 
}
