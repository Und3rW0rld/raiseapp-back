package com.ashen.raiseback.model;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @Column(name="USER_ID")
    private long userId;

    @Column(name="SCORE")
    private short score;

    @ManyToOne
    @JoinColumn(name = "BUSINESS_ID")
    private Business business;

    public Score(long userId, Business business, short score) {
        this.userId = userId;
        this.business = business;
        this.score = score;
    }
}