package com.example.backendspring.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

    @Getter
    @Setter
    @Entity
    public class Ville {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String nom;
        @JsonIgnore
        @OneToMany(mappedBy = "ville", fetch = FetchType.LAZY,
                cascade = CascadeType.ALL)
        private Set<Zone> zones;
    }

