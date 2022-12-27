package com.example.backendspring.repository;

import com.example.backendspring.beans.Specialite;
import com.example.backendspring.beans.Ville;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialiteRepository extends JpaRepository<Specialite, Integer> {
    Specialite findById(int id);
}
