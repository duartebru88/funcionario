package br.com.funcionario.ada.service;

import br.com.funcionario.ada.dto.CargoResponseDto;
import br.com.funcionario.ada.entity.Cargo;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface CargoService {

    Cargo save(Cargo cargo);

    Optional<Cargo> findById(Long idCargo);

    void deleteById(Long idCargo);

    List<Cargo>  findAll();

}
