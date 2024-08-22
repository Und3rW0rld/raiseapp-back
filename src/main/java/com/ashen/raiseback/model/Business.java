package com.ashen.raiseback.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
public class Business {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private long id;

    @Column(name="NAME")
    private String name;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name="CONTACT_MESSAGE")
    private String contact_message;

    @Column(name="EMAIL")
    private String email;

    @Column(name="PHONE")
    private String phone;

    @Column(name="FACEBOOK")
    private String facebook;

    @Column(name="INSTAGRAM")
    private String instagram;

    @Column(name = "CITY")
    private String city;

    @Column(name = "ADDRESS")
    private String address;

    //La wallet será para cada emprendimiento ya que pueden destinarse diferentes wallets para varios emprendimientos
    @Column(name = "WALLET_KEY", unique = true)
    private String wallet_key;

    @OneToMany(mappedBy = "business", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Investment> investments = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "ENTREPRENEUR_ID", referencedColumnName = "ID")
    private Entrepreneur entrepreneur;

    @Column(name="BUSINESS_IMAGE")
    private String image;

    @OneToMany(mappedBy = "business", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Score> scores = new ArrayList<>();

    @ElementCollection
    private List<String> images;

    public Business() {
    }
    
    //Calculate average score of business
    public double getAverageScore() {
        return scores.stream()
                .mapToInt(Score::getScore)
                .average()
                .orElse(0.0);
    }

    public double getValue() {
        double value = 0;
        for( Investment i : this.investments ){
            value += i.getAmount().doubleValue();
        }
        return value;
    }

}
