package br.com.funcionario.ada.entity;

import br.com.funcionario.ada.entity.enums.CargoEnum;
import br.com.funcionario.ada.entity.enums.PerfilEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Data
@Entity
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private BigDecimal bonusSalarial;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cargo_id", referencedColumnName = "id")
    private Cargo cargo;

    @Enumerated(EnumType.STRING)
    private PerfilEnum perfil;
    //coments

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;
    //commit
}
