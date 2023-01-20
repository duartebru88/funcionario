package br.com.funcionario.ada.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
public class Endereco {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String logradouro;
        private String bairro;
        private String cidade;

        @Column(name = "uf", length = 2)
        private String uf;

        @Column(name = "cep", length = 9)
        private String cep;

}
