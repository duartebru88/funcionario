package br.com.funcionario.ada.service.impl;

import br.com.funcionario.ada.entity.Cargo;
import br.com.funcionario.ada.repository.CargoRepository;
import br.com.funcionario.ada.repository.FuncionarioRepository;
import br.com.funcionario.ada.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CargoServiceImpl implements CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    @Override
    public Cargo save(Cargo cargo) {
        return cargoRepository.save(cargo);
    }

    @Override
    public Optional<Cargo> findById(Long idCargo) {
        return cargoRepository.findById(idCargo);
    }

    @Override
    public void deleteById(Long idCargo) {
        cargoRepository.deleteById(idCargo);
    }

    @Override
    public List<Cargo> findAll(){
        return cargoRepository.findAll();
    }

}
