package com.orangetalents.cadastro.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.orangetalents.cadastro.dto.ErroCep;
import com.orangetalents.cadastro.dto.ViaCepDTO;

@FeignClient(url = "https://viacep.com.br/ws/", name = "viacep")
public interface CepService {

	@GetMapping("{cep}/json")
	public ViaCepDTO buscaCep(@PathVariable("cep") String cep);
	
	@GetMapping("{cep}/json")
	public ErroCep buscaErro(@PathVariable("cep") String cep);
	
}
