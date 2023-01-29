package br.com.funcionario.ada.dto;

import br.com.funcionario.ada.entity.Endereco;
import br.com.funcionario.ada.entity.enums.PerfilEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class FuncionarioSaveRequestDto {
    @NotNull
    @NotBlank
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private Endereco endereco;
    private Long cargoId;
    private PerfilEnum perfil;
    private BigDecimal bonusSalarial;
}
