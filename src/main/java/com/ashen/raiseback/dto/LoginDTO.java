package com.ashen.raiseback.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginDTO {

    // Getters y Setters
    private String email;
    private String password;

    // Constructor vacío
    public LoginDTO() {
    }

    // Constructor con parámetros
    public LoginDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
