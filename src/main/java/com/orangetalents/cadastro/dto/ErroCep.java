package com.orangetalents.cadastro.dto;


public class ErroCep {

	private String erro;

	public ErroCep () {
		
	}
	public ErroCep(String erro) {
		super();
		this.erro = erro;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

}
