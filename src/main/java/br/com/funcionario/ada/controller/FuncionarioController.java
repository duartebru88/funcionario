package br.com.funcionario.ada.controller;

import br.com.funcionario.ada.dto.*;
import br.com.funcionario.ada.entity.Cargo;
import br.com.funcionario.ada.entity.Funcionario;
import br.com.funcionario.ada.service.impl.CargoServiceImpl;
import br.com.funcionario.ada.service.impl.FuncionarioServiceImpl;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioServiceImpl funcionarioService;
    @Autowired
    private CargoServiceImpl cargoService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<FuncionarioSaveResponseDto> save(@RequestBody @Valid FuncionarioSaveRequestDto funcionarioRequest){


        log.info(funcionarioRequest.toString());
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(funcionarioRequest.getNome());
        funcionario.setCpf(funcionarioRequest.getCpf());
        funcionario.setEmail(funcionarioRequest.getCpf());
        funcionario.setSenha(funcionarioRequest.getCpf());
        funcionario.setEndereco(funcionarioRequest.getEndereco());
        Optional<Cargo> cargo = cargoService.findById(funcionarioRequest.getCargoId());
        funcionario.setCargo(cargo.get());
        funcionario.setPerfil(funcionarioRequest.getPerfil());
        funcionario.setBonusSalarial(funcionarioRequest.getBonusSalarial());
        funcionarioService.save(funcionario);
        FuncionarioSaveResponseDto funcionarioResponse = new FuncionarioSaveResponseDto();
        funcionarioResponse.setId(funcionario.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioResponse);

    }
    @GetMapping(value = "/{idFuncionario}")
    public ResponseEntity<FuncionarioResponseDto> getById(@PathVariable(value = "idFuncionario") Long id) {

        Optional<Funcionario> funcionario = funcionarioService.findById(id);

        if (funcionario.isPresent()) {
            FuncionarioResponseDto funcionarioResponse = modelMapper.map(funcionario.get(), FuncionarioResponseDto.class);
            return ResponseEntity.ok(funcionarioResponse);

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PatchMapping("/{idFuncionario}/{bonusSalarial}")
    public ResponseEntity updatebonusSalarial(@PathVariable Long idFuncionario, @PathVariable BigDecimal bonusSalarial) {
        //update
        log.info("idFuncionario: {} bonusSalarial: {}", idFuncionario, bonusSalarial);
        Optional<Funcionario> funcionario = funcionarioService.findById(idFuncionario);

        if (funcionario.isPresent()) {
            funcionario.get().setBonusSalarial(bonusSalarial);
            funcionarioService.save(funcionario.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @DeleteMapping("/{idFuncionario}")
    public ResponseEntity<String> delete(@PathVariable Long idFuncionario) {

        Optional<Funcionario> funcionario = funcionarioService.findById(idFuncionario);
        if (funcionario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        funcionarioService.deleteById(idFuncionario);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{idFuncionario}")
    public ResponseEntity update(@PathVariable Long idFuncionario, @RequestBody @Valid FuncionarioSaveRequestDto funcionarioRequest) {

        Optional<Funcionario> funcionarioOptional = funcionarioService.findById(idFuncionario);

        if (funcionarioOptional.isPresent()) {
            Funcionario funcionario = modelMapper.map(funcionarioRequest, Funcionario.class);
            funcionarioService.save(funcionario);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @GetMapping
    public ResponseEntity<List<Funcionario>> findAll() {return ResponseEntity.ok(funcionarioService.findAll());
    }


    @GetMapping("/{idFuncionario}/salario")
    public String calculaSalario(@PathVariable Long idFuncionario) {
        Optional<Funcionario> funcionario = funcionarioService.findById(idFuncionario);
        Optional<Cargo> cargo = cargoService.findById(funcionario.get().getCargo().getId());
        BigDecimal salario = funcionario.get().getBonusSalarial().add(cargo.get().getSalario());

        return salario.toString();
    }

}
