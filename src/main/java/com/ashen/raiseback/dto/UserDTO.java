package com.ashen.raiseback.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDTO {
    private long id;
    private String name;
    private String email;
    private String type;
    private String publicKey;
    private String password;  // Incluye el campo password
    private String image;

    public UserDTO(long id, String name, String email, String type, String publicKey, String password, String image) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.type = type;
        this.publicKey = publicKey;
        this.password = password;
        this.image = image;
    }

    public UserDTO(String name, String email, String type, String publicKey, String password, String image) {
        this.name = name;
        this.email = email;
        this.type = type;
        this.publicKey = publicKey;
        this.password = password;
        this.image = image;
    }

    public UserDTO() {
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", type='" + type + '\'' +
                ", publicKey='" + publicKey + '\'' +
                ", password='" + password + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
