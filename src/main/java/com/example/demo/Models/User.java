package com.example.demo.Models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "MAIL")
    private String mail;

    @Column(name = "NOM")
    private String nom;

    @Column(name = "PRENOM")
    private String prenom;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "ADRESSE")
    private String adresse;

    @Column(name = "CIN")
    private String cin;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Commande> commandes;

    @Column(name = "admin")
    private boolean admin;

    public User() {
    }


    public User(String mail, String nom, String prenom, String password, String adresse, String cin, List<Commande> commandes, boolean admin) {
        this.mail = mail;
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
        this.adresse = adresse;
        this.cin = cin;
        this.commandes = commandes;
        this.admin = admin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
