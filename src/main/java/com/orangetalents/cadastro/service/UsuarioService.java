package com.orangetalents.cadastro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orangetalents.cadastro.dto.EnderecoDTO;
import com.orangetalents.cadastro.dto.UsuarioDTO;
import com.orangetalents.cadastro.dto.UsuarioEnderecoDTO;
import com.orangetalents.cadastro.dto.ViaCepDTO;
import com.orangetalents.cadastro.exceptions.BadRequestException;
import com.orangetalents.cadastro.exceptions.ObjectNotFoundException;
import com.orangetalents.cadastro.model.Endereco;
import com.orangetalents.cadastro.model.Usuario;
import com.orangetalents.cadastro.repository.EnderecoRepository;
import com.orangetalents.cadastro.repository.UsuarioRepository;


@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository userrepo;

	@Autowired
	EnderecoRepository addresrepo;

	@Autowired
	CepService cepservice;

	public void criarUsuario(Usuario user) {

		if (userrepo.findByCPF(user.getCpf()) != null) {
			throw new BadRequestException("Este CPF já está em uso, cadastro não realizado.");
		}

		if (userrepo.findByEmail(user.getEmail()) != null) {
			throw new BadRequestException("Este E-mail já está em uso, cadastro não realizado.");
		}

		userrepo.save(user);
	}

	public void criarEndereco(Endereco end) {
		addresrepo.save(end);
	}

	public Usuario userFromDTO(UsuarioDTO user) {
		Usuario us = new Usuario(user.getNome(), user.getEmail(), user.getCpf(), user.getNascimento());
		return us;
	}

	public Endereco fromViaCep(EnderecoDTO ende) {

		if (!userrepo.existsById(ende.getIdUsuario())) {
			throw new BadRequestException("Usuário não encontrado, cadastro não realizado");

		}

		Usuario us = userrepo.findById(ende.getIdUsuario()).orElse(null);

		if (cepservice.buscaErro(ende.getCep()).getErro() != null) {
			throw new BadRequestException("CEP não encontrado");
		}

		ViaCepDTO viacep = cepservice.buscaCep(ende.getCep());

		Endereco end = new Endereco(ende.getLogradouro(), viacep.getCep(), ende.getNumero(), ende.getComplemento(),
				viacep.getLocalidade(), viacep.getBairro(), viacep.getUf(), us);

		us.getEndereco().add(end);

		return end;
	}

	public UsuarioEnderecoDTO listaEndereco(String id) {

		Long id1 = Long.parseLong(id);

		if (!userrepo.existsById(id1)) {
			throw new ObjectNotFoundException("Usuário de ID: " + id + " não encontrado!");
		}

		Usuario user = userrepo.findById(id1).orElse(null);

		UsuarioEnderecoDTO usend = new UsuarioEnderecoDTO(user.getNome(), user.getEndereco());

		return usend;

	}
}
