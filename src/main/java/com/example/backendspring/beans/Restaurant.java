package com.example.backendspring.beans;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String nom;
    private String adresse;

    private double latitude;
    private double longitude;
    private String rank;

    @Temporal(TemporalType.TIME)
    @JsonFormat(pattern="HH:mm")
    private Date heureOpen;
    @Temporal(TemporalType.TIME)
    @JsonFormat(pattern="HH:mm")
    private Date heureClose;



    //Serie

    @ManyToOne
    @JoinColumn(name = "serie_id")
    private Serie serie;

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    //Fin Serie

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    // pour le test

    // fin de test
}
