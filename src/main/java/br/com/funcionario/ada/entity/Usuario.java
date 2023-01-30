package br.com.funcionario.ada.entity;

import br.com.funcionario.ada.entity.enums.PerfilEnum;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private String email;
    private String senha;

    @Enumerated(EnumType.STRING)
    private PerfilEnum perfil;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

}
