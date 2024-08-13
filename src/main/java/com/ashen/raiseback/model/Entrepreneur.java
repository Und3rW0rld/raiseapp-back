package com.ashen.raiseback.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Entrepreneur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "USUARIO_ID", referencedColumnName = "ID")
    private User user;

    @OneToMany(mappedBy = "entrepreneur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Business> businesses = new ArrayList<>();

    public Entrepreneur(long id, User user) {
        this.id = id;
        this.user = user;
    }

    public Entrepreneur() {

    }

    public Entrepreneur(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "Entrepreneur{" +
                "id=" + id +
                ", user=" + user +
                '}';
    }
}
