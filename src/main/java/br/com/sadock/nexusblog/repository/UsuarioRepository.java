package br.com.sadock.nexusblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sadock.nexusblog.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
