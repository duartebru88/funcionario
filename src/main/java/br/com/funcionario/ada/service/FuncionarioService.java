package br.com.funcionario.ada.service;

import br.com.funcionario.ada.entity.Funcionario;

import java.util.List;
import java.util.Optional;

public interface FuncionarioService {

    Funcionario save(Funcionario funcionario);

    Optional<Funcionario> findById(Long idFuncionario);

    void deleteById(Long idFuncionario);

    List<Funcionario> findAll();

}
