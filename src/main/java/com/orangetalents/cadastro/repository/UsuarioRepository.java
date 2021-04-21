package com.orangetalents.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.orangetalents.cadastro.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	@Query("SELECT u from Usuario u WHERE u.cpf=?1")
	public Usuario findByCPF(String cpf);
	
	@Query("SELECT u from Usuario u WHERE u.email=?1")
	public Usuario findByEmail(String email);
	
}
