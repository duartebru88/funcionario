package br.com.funcionario.ada.config.security;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginDto {

    private String email;
    private String senha;

}
