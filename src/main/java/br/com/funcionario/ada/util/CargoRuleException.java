package br.com.funcionario.ada.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CargoRuleException extends BaseRuntimeException {

    private static final String KEY = "cargo.cargo.rule";

    public CargoRuleException() {
        super();
    }

    @Override
    public String getExceptionKey() {
        return KEY;
    }
}
