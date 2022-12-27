package com.example.backendspring.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Zone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;

    @JsonIgnore
    @ManyToOne(optional = true)
    @JoinColumn(name = "ville_id", nullable = false)
    private Ville ville;


    @OneToMany(mappedBy = "zone", fetch = FetchType.EAGER)
    private List<Restaurant> restaurants;

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

    @Override
    public String toString() {
        return "Zone{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", ville=" + ville +
                ", restaurants=" + restaurants +
                '}';
    }
}
