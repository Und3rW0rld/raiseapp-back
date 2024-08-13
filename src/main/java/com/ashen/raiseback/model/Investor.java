package com.ashen.raiseback.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Investor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @OneToOne
    @JoinColumn(name = "USUARIO_ID", referencedColumnName = "ID")
    private User user;

    @OneToMany(mappedBy = "investor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Investment> investment = new ArrayList<>();

    public Investor(long id, User user, List<Investment> investment) {
        this.id = id;
        this.user = user;
        this.investment = investment;
    }

    public Investor() {
    }

    public Investor(User user, List<Investment> investment) {
        this.user = user;
        this.investment = investment;
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

    public List<Investment> getInvestment() {
        return investment;
    }

    public void setInvestment(List<Investment> investment) {
        this.investment = investment;
    }

    @Override
    public String toString() {
        return "Inversor{" +
                "id=" + id +
                ", user=" + user +
                ", investment=" + investment +
                '}';
    }
}
