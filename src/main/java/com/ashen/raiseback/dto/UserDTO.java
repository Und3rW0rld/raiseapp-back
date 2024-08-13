package com.ashen.raiseback.dto;

public class UserDTO {
    private long id;
    private String name;
    private String email;
    private String type;
    private String publicKey;
    private String password;  // Incluye el campo password

    // Constructores
    public UserDTO() {
    }

    public UserDTO(long id, String name, String email, String type, String publicKey, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.type = type;
        this.publicKey = publicKey;
        this.password = password;
    }

    public UserDTO(String name, String email, String type, String publicKey, String password) {
        this.name = name;
        this.email = email;
        this.type = type;
        this.publicKey = publicKey;
        this.password = password;
    }

    // Getters y Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
                '}';
    }
}
