package com.example.backendspring.beans;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;

@Entity
public class Zone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    @ManyToOne
    private Ville ville;
    @OneToMany(mappedBy = "zone")
    private Collection<Restaurant> restaurant ;


    public Zone() {
        super();
    }

    public Zone(String nom, Ville ville, Collection<Restaurant> restaurant) {
        super();
        this.nom = nom;
        this.ville = ville;
        this.restaurant = restaurant;
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

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }


    @JsonIgnore
    public Collection<Restaurant> getRestaurant() {
        return restaurant;
    }
    @JsonSetter
    public void setRestaurant(Collection<Restaurant> restaurant) {
        this.restaurant = restaurant;
    }


    @Override
    public String toString() {
        return "Zone{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", ville=" + ville +
                ", restaurants=" + restaurant +
                '}';
    }
}
