package br.com.funcionario.ada.dto;

import br.com.funcionario.ada.entity.enums.CargoEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CargoResponseDto {

    private Long id;
    private String descricao;
    private BigDecimal salario_base;
    private CargoEnum cargo;

}
