package com.example.backendspring.repository;

import com.example.backendspring.beans.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {
    @Query(value = "select * from restaurant where id =:id",nativeQuery = true)
    Restaurant getRestaurantById(Long id);

    @Query(value = "select * from restaurant",nativeQuery = true)
    List<Restaurant> getAllRestaurant();

}
