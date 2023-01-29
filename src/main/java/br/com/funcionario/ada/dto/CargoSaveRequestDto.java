package br.com.funcionario.ada.dto;

import br.com.funcionario.ada.entity.enums.CargoEnum;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


import java.math.BigDecimal;

@Data
public class CargoSaveRequestDto {

    @NotNull
    private CargoEnum cargo;
    private String descricao;
    @NotNull
    @DecimalMin(value = "0.1")
    private BigDecimal salario;

}
