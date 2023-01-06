package com.example.backendspring.beans;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne
    @JoinColumn(name = "zone_id")
    private Zone zone;
    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }
    //Fin Serie


    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Specialite> specialite;


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
