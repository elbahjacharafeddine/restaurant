package com.example.backendspring.beans;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class Specialite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Restaurant> restaurant;

}
