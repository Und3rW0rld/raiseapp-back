package com.ashen.raiseback.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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

    public Business() {
    }

    public Business(long id, String name, String description, String contact_message, String email, String phone, String facebook, String instagram, String address, String wallet_key, List<Investment> investments, Entrepreneur entrepreneur) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.contact_message = contact_message;
        this.email = email;
        this.phone = phone;
        this.facebook = facebook;
        this.instagram = instagram;
        this.address = address;
        this.wallet_key = wallet_key;
        this.investments = investments;
        this.entrepreneur = entrepreneur;
    }

    public Business(String name, String description, String contact_message, String email, String phone, String facebook, String instagram, String address, String wallet_key, List<Investment> investments, Entrepreneur entrepreneur) {
        this.name = name;
        this.description = description;
        this.contact_message = contact_message;
        this.email = email;
        this.phone = phone;
        this.facebook = facebook;
        this.instagram = instagram;
        this.address = address;
        this.wallet_key = wallet_key;
        this.investments = investments;
        this.entrepreneur = entrepreneur;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContact_message() {
        return contact_message;
    }

    public void setContact_message(String contact_message) {
        this.contact_message = contact_message;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWallet_key() {
        return wallet_key;
    }

    public void setWallet_key(String wallet_key) {
        this.wallet_key = wallet_key;
    }

    public List<Investment> getInvestments() {
        return investments;
    }

    public void setInvestments(List<Investment> investments) {
        this.investments = investments;
    }

    public Entrepreneur getEntrepreneur() {
        return entrepreneur;
    }

    public void setEntrepreneur(Entrepreneur entrepreneur) {
        this.entrepreneur = entrepreneur;
    }

    @Override
    public String toString() {
        return "Business{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", contact_message='" + contact_message + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", facebook='" + facebook + '\'' +
                ", instagram='" + instagram + '\'' +
                ", address='" + address + '\'' +
                ", wallet_key='" + wallet_key + '\'' +
                ", investments=" + investments +
                ", entrepreneur=" + entrepreneur +
                '}';
    }
}
