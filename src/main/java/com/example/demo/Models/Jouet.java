package com.example.demo.Models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "JOUET")
public class Jouet {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NOM")
    private String nom;

    @Column(name = "PRIX")
    private double prix;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToMany(mappedBy = "jouets")
    private List<Commande> commandes;

    @Column(name = "PHOTO")
    private String photo;

    public Jouet() {
    }

    public Jouet(String nom, double prix, String description, List<Commande> commandes, String photo) {
        this.nom = nom;
        this.prix = prix;
        this.description = description;
        this.commandes = commandes;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
