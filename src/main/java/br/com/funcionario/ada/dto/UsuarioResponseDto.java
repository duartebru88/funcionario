package br.com.funcionario.ada.dto;

import br.com.funcionario.ada.entity.enums.PerfilEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioResponseDto {

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private EnderecoDto endereco;
    private PerfilEnum perfil;

}
