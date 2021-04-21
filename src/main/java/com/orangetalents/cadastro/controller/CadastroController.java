package com.orangetalents.cadastro.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orangetalents.cadastro.dto.EnderecoDTO;
import com.orangetalents.cadastro.dto.UsuarioDTO;
import com.orangetalents.cadastro.dto.UsuarioEnderecoDTO;
import com.orangetalents.cadastro.model.Endereco;
import com.orangetalents.cadastro.model.Usuario;
import com.orangetalents.cadastro.service.UsuarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@Api(value="Endpoints")
@RestController
@RequestMapping(value = "")
public class CadastroController {

	@Autowired
	UsuarioService service;

	@ApiOperation(value="Cadastra um usuário")
	@PostMapping(value = "/cadastrousuario")
	public ResponseEntity<UsuarioDTO> cadastroUsuario(@Valid @RequestBody UsuarioDTO user) {
		Usuario us = service.userFromDTO(user);
		service.criarUsuario(us);
		return new ResponseEntity<UsuarioDTO>(user, HttpStatus.CREATED);
	}

	@ApiOperation(value="Cadastra um endereço")
	@PostMapping(value = "/cadastroendereco")
	public ResponseEntity<Endereco> cadastroEndereco(@Valid @RequestBody EnderecoDTO ende) {
		Endereco end = service.fromViaCep(ende);
        service.criarEndereco(end);
        return new ResponseEntity<Endereco>(end, HttpStatus.CREATED);
	}
	
	@ApiOperation(value="Retorna a lista de endereços de um usuário através do ID do usuário")
	@GetMapping(value = "/buscaenderecos/{id}")
	public ResponseEntity<UsuarioEnderecoDTO> buscaEnderecos(@PathVariable String id) {
		UsuarioEnderecoDTO lista = service.listaEndereco(id);
		return ResponseEntity.ok().body(lista);
	}
}
