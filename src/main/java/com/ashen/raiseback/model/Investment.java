package com.ashen.raiseback.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Investment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "INVESTOR_ID", referencedColumnName = "ID")
    private Investor investor;

    @ManyToOne
    @JoinColumn(name = "BUSINESS_ID", referencedColumnName = "ID")
    private Business business;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Column(name = "DATE")
    private LocalDateTime date;

    public Investment() {
    }

    public Investment(long id, Investor investor, Business business, BigDecimal amount, LocalDateTime date) {
        this.id = id;
        this.investor = investor;
        this.business = business;
        this.amount = amount;
        this.date = date;
    }

    public Investment(Investor investor, Business business, BigDecimal amount, LocalDateTime date) {
        this.investor = investor;
        this.business = business;
        this.amount = amount;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Investor getInvestor() {
        return investor;
    }

    public void setInvestor(Investor investor) {
        this.investor = investor;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Investment{" +
                "id=" + id +
                ", investor=" + investor +
                ", business=" + business +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
