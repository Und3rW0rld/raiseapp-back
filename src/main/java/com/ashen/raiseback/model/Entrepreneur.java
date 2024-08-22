package com.ashen.raiseback.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
public class Entrepreneur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "USUARIO_ID", referencedColumnName = "ID")
    private User user;

    @JsonIgnore
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
}
