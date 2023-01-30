package br.com.funcionario.ada.service.impl;

import br.com.funcionario.ada.entity.Usuario;
import br.com.funcionario.ada.repository.UsuarioRepository;
import br.com.funcionario.ada.service.UsuarioService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository usuarioRepository;
    final PasswordEncoder passwordEncoder;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Usuario save(Usuario usuario) {
        if (Objects.isNull(usuario.getId())) {
            usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        }
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> findById(Long idUsuario) {
        return usuarioRepository.findById(idUsuario);
    }

}
