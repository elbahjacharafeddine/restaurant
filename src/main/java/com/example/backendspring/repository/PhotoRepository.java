package com.example.backendspring.repository;

import com.example.backendspring.beans.Photo;
import com.example.backendspring.beans.Restaurant;
import com.example.backendspring.beans.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PhotoRepository extends JpaRepository<Photo, Integer> {
    Photo findById(int id);
    @Query(value = "select * from photo where restaurant_id=?",nativeQuery = true)
    List<Photo> findAllByR();
}

