package br.com.funcionario.ada.service.impl;

import br.com.funcionario.ada.entity.User;
import br.com.funcionario.ada.repository.UserRepository;
import br.com.funcionario.ada.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findById(String username) {
        return userRepository.findById(username);
    }

    @Override
    public List<User> findAll(){
        return userRepository.findAll();
    }

}
