package com.orangetalents.cadastro.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EnderecoDTO {

	@NotNull(message = "Id do usuário não pode estar em branco")
	private Long idUsuario;
	
	private String cep;
	
	@NotBlank(message = "Número não pode estar em branco")
	private String numero;
	
	
	private String complemento;
	
	@NotBlank(message= "Logradouro não pode estar em branco")
	private String logradouro;


	
	public EnderecoDTO(Long idUsuario, @NotBlank String cep, @NotBlank String numero, String complemento, String logradouro) {
		super();
		this.idUsuario = idUsuario;
		this.cep = cep;
		this.numero = numero;
		this.complemento = complemento;
		this.logradouro = logradouro;
	}


	public Long getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getComplemento() {
		return complemento;
	}


	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}


	public String getLogradouro() {
		return logradouro;
	}


	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	
}
