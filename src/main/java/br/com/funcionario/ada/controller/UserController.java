package br.com.funcionario.ada.controller;


import br.com.funcionario.ada.dto.CargoResponseDto;
import br.com.funcionario.ada.dto.CargoSaveRequestDto;
import br.com.funcionario.ada.dto.CargoSaveResponseDto;
import br.com.funcionario.ada.dto.UserDto;
import br.com.funcionario.ada.entity.Cargo;
import br.com.funcionario.ada.entity.User;
import br.com.funcionario.ada.service.impl.CargoServiceImpl;
import br.com.funcionario.ada.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping
    public ResponseEntity<UserDto> save(@Validated @RequestBody @Valid UserDto userDto) {

        log.info(userDto.toString());
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(bCryptPasswordEncoder
                .encode(userDto.getPassword()));
        userService.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
    }
//
//    @GetMapping(value = "/{idCargo}")
//    public ResponseEntity<CargoResponseDto> getById(@PathVariable(value = "idCargo") Long id) {
//
//        Optional<Cargo> cargo = cargoService.findById(id);
//
//        if (cargo.isPresent()) {
//            CargoResponseDto cargoResponse = modelMapper.map(cargo.get(), CargoResponseDto.class);
//            return ResponseEntity.ok(cargoResponse);
//
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Cargo>> findAll() {
//        return ResponseEntity.ok(cargoService.findAll());
//    }

}
