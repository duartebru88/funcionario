package br.com.funcionario.ada.service.impl;

import br.com.funcionario.ada.entity.Funcionario;
import br.com.funcionario.ada.repository.FuncionarioRepository;
import br.com.funcionario.ada.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public Funcionario save(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @Override
    public Optional<Funcionario> findById(Long idFuncionario) {
        return funcionarioRepository.findById(idFuncionario);
    }

    @Override
    public void deleteById(Long idFuncionario) {
        funcionarioRepository.deleteById(idFuncionario);
    }

    @Override
    public List<Funcionario> findAll(){
        return funcionarioRepository.findAll();
    }
}
