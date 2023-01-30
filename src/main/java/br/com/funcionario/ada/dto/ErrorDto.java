package br.com.funcionario.ada.dto;

import lombok.Data;

@Data
public class ErrorDto {
    private String key;
    private String message;

    public ErrorDto() {
    }

    public ErrorDto(String key, String message) {
        this.key = key;
        this.message = message;
    }

}
