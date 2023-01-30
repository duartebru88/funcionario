package br.com.funcionario.ada.service;

import br.com.funcionario.ada.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User save(User user);

    Optional<User> findById(String username);

    List<User> findAll();

}
