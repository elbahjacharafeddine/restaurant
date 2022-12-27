package com.example.backendspring.repository;

import com.example.backendspring.beans.Serie;
import com.example.backendspring.beans.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepository extends JpaRepository<Serie, Integer> {
    Serie findById(int id);
}

