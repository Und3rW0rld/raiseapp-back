package com.ashen.raiseback.dto;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
