package br.com.funcionario.ada.dto;

import br.com.funcionario.ada.entity.Cargo;
import br.com.funcionario.ada.entity.Endereco;
import br.com.funcionario.ada.entity.enums.PerfilEnum;
import lombok.Getter;
import lombok.Setter;

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
}
