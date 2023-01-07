package com.example.backendspring.controller;

import com.example.backendspring.beans.Restaurant;
import com.example.backendspring.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

        System.out.println(restaurant.getZone().toString());
        restaurantRepository.save(restaurant);
    }

    @GetMapping("/all")
    List<Restaurant> getAllRestaurant(){
        return restaurantRepository.findAll();
    }
    @GetMapping("/allE")
    List<Restaurant> getAllRestaurant0(){
        return restaurantRepository.findAllBy();
    }
    @GetMapping("/allV")
    List<Restaurant> getAllRestaurantV(){
        return restaurantRepository.findAllByV();
    }

    @DeleteMapping("/delete/{id}")
    void deleteRestaurant(@PathVariable Long id){
        restaurantRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    Restaurant getRestaurantById(@PathVariable Long id){
        return restaurantRepository.findById(id).get();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> updateSerie(@PathVariable int id, @RequestBody Restaurant restaurant){

        Restaurant existE =restaurantRepository.findById(id);
        existE.setEtat(restaurant.getEtat());
        restaurantRepository.save(existE);
        return ResponseEntity.ok(existE);

    }
    @GetMapping("/allstat")
    List<Object[]> getAllRestaurantstat(){
        return restaurantRepository.listeRestaurant();
    }
    @GetMapping("/allstatV")
    List<Object[]> getAllRestaurantstatV(){
        return restaurantRepository.listeRestaurantville();
    }
}
