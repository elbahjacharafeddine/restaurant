package com.example.backendspring.controller;

import com.example.backendspring.beans.Restaurant;
import com.example.backendspring.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    RestaurantRepository restaurantRepository;
    @PostMapping("/add")
    void addRestaurant(@RequestBody Restaurant restaurant){
        restaurantRepository.save(restaurant);
    }

    @GetMapping("/all")
    List<Restaurant> getAllRestaurant(){
        return restaurantRepository.findAll();
    }

    @GetMapping("/delete/{id}")
    void deleteRestaurant(@PathVariable Long id){
        restaurantRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    Restaurant getRestaurantById(@PathVariable Long id){
        return restaurantRepository.getRestaurantById(id);
    }

}
