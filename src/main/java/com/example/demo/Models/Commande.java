package com.example.demo.Models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "COMMANDE")
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "DATE")
    private Date date;

    @Column(name = "PRIXTOTAL")
    private double prixTotal;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Commande_jouet",
            joinColumns = { @JoinColumn(name = "commande_id") },
            inverseJoinColumns = { @JoinColumn(name = "jouet_id") }
    )
    private List<Jouet> jouets;

    public Commande() {
    }

    public Commande(Date date, double prixTotal, User user, List<Jouet> jouets) {
        this.date = date;
        this.prixTotal = prixTotal;
        this.user = user;
        this.jouets = jouets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(double prixTotal) {
        this.prixTotal = prixTotal;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Jouet> getJouets() {
        return jouets;
    }

    public void setJouets(List<Jouet> jouets) {
        this.jouets = jouets;
    }
}
