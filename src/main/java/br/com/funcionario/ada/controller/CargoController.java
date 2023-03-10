package br.com.funcionario.ada.controller;


import br.com.funcionario.ada.dto.CargoResponseDto;
import br.com.funcionario.ada.dto.CargoSaveRequestDto;
import br.com.funcionario.ada.dto.CargoSaveResponseDto;
import br.com.funcionario.ada.entity.Cargo;
import br.com.funcionario.ada.service.impl.CargoServiceImpl;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/cargos")
public class CargoController {

   @Autowired
   private CargoServiceImpl cargoService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<CargoSaveResponseDto> save(@Validated @RequestBody @Valid CargoSaveRequestDto cargoRequest) {

        log.info(cargoRequest.toString());
        Cargo cargo = modelMapper.map(cargoRequest, Cargo.class);

        cargoService.save(cargo);

        CargoSaveResponseDto cargoResponse = new CargoSaveResponseDto();
        cargoResponse.setId(cargo.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(cargoResponse);
    }

    @GetMapping(value = "/{idCargo}")
    public ResponseEntity<CargoResponseDto> getById(@PathVariable(value = "idCargo") Long id) {

        Optional<Cargo> cargo = cargoService.findById(id);

        if (cargo.isPresent()) {
            CargoResponseDto cargoResponse = modelMapper.map(cargo.get(), CargoResponseDto.class);
            return ResponseEntity.ok(cargoResponse);

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PatchMapping("/{idCargo}")
    public ResponseEntity updateSalario(@PathVariable Long idCargo, @RequestBody @Valid CargoSaveRequestDto cargoRequest) {
        //update
        log.info("idCargo: {}", idCargo);
        Optional<Cargo> cargo = cargoService.findById(idCargo);
        Cargo cargoAtualizado = new Cargo();
        if (cargo.isPresent()) {
            cargoAtualizado.setId(cargo.get().getId());
            cargoAtualizado.setCargo(cargoRequest.getCargo());
            cargoAtualizado.setDescricao(cargoRequest.getDescricao());
            cargoAtualizado.setSalario(cargoRequest.getSalario());
            cargoService.save(cargoAtualizado);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{idCargo}")
    public ResponseEntity<String> delete(@PathVariable Long idCargo) {

        Optional<Cargo> cargo = cargoService.findById(idCargo);
        if (cargo.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        cargoService.deleteById(idCargo);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{idCargo}")
    public ResponseEntity update(@PathVariable Long idCargo, @RequestBody @Valid CargoSaveRequestDto cargoRequest) {

        Optional<Cargo> cargoOptional = cargoService.findById(idCargo);

        if (cargoOptional.isPresent()) {
            Cargo cargo = modelMapper.map(cargoRequest, Cargo.class);
            cargoService.save(cargo);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @GetMapping
    public ResponseEntity<List<Cargo>> findAll() {
       return ResponseEntity.ok(cargoService.findAll());
    }



}
