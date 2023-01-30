package br.com.funcionario.ada.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data

public class User implements Serializable {
    @Id
    @Column
    private String username;
    @Column
    private String password;


}
