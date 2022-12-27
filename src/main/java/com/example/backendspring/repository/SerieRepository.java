package com.example.backendspring.repository;

import com.example.backendspring.beans.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepository extends JpaRepository<Serie, Integer> {
}

