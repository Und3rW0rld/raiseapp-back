package com.ashen.raiseback.model;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE")
    private UserType type;

    @Column(name = "PUBLIC_KEY", unique = true)
    private String publicKey;

    @Column(name = "USER_IMAGE")
    private String image;

    public User(long id, String name, String password, String email, UserType type, String publicKey, String image) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.type = type;
        this.publicKey = publicKey;
        this.image = image;
    }

    public User(String name, String password, String email, UserType type, String publicKey, String image) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.type = type;
        this.publicKey = publicKey;
        this.image = image;
    }

    public User() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", type=" + type +
                ", publicKey='" + publicKey + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
