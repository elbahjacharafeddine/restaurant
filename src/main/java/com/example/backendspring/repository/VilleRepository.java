package com.example.backendspring.repository;

import com.example.backendspring.beans.Ville;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VilleRepository extends JpaRepository<Ville, Integer> {
}
