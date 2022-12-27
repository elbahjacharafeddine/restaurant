package com.example.backendspring.beans;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Specialite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    @ManyToMany(mappedBy = "specialite",fetch=FetchType.EAGER)
    private List<Restaurant> restaurants;

}
