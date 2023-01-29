package br.com.funcionario.ada.entity;

import br.com.funcionario.ada.entity.enums.CargoEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;


@Data
@Entity
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private CargoEnum cargo;
    private String descricao;
    private BigDecimal salario;

}
