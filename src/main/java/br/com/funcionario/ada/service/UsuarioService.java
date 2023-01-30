package br.com.funcionario.ada.service;

import br.com.funcionario.ada.entity.Usuario;

import java.util.Optional;


public interface UsuarioService {

    Usuario save(Usuario usuario);

    Optional<Usuario> findById(Long idUsuario);

}
