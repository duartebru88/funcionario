package br.com.funcionario.ada.repository;

import br.com.funcionario.ada.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);
}
