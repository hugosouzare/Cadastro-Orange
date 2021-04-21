package com.orangetalents.cadastro.dto;

import java.util.ArrayList;
import java.util.List;

import com.orangetalents.cadastro.model.Endereco;

public class UsuarioEnderecoDTO {

	private String usuario;
	
	private List<Endereco> endereco = new ArrayList<>();

	
	public UsuarioEnderecoDTO(String usuario, List<Endereco> endereco) {
		super();
		this.usuario = usuario;
		this.endereco = endereco;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}
	
	
}
