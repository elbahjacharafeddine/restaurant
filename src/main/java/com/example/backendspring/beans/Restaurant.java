package com.example.backendspring.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

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

    //Photo
    @JsonIgnore
    @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Photo> photos;
    //Fin Photo

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    // pour le test

    // fin de test
}
