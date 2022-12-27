package com.example.backendspring.repository;

import com.example.backendspring.beans.Photo;
import com.example.backendspring.beans.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Integer> {
    Photo findById(int id);
}

