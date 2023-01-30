package br.com.funcionario.ada.dto;

import br.com.funcionario.ada.entity.enums.CargoEnum;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CargoResponseDto {

    private Long id;
    private CargoEnum cargo;
    private String descricao;
    private BigDecimal salario;

}
