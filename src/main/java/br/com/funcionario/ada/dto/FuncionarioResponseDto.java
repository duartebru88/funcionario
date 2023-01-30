package br.com.funcionario.ada.dto;

import br.com.funcionario.ada.entity.Cargo;
import br.com.funcionario.ada.entity.Endereco;
import br.com.funcionario.ada.entity.enums.PerfilEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class FuncionarioResponseDto {
        private Long id;
        private String nome;
        private String cpf;
        private String email;
        private Endereco endereco;
        private Cargo cargo;
        private PerfilEnum perfil;
        private BigDecimal bonusSalarial;
}
