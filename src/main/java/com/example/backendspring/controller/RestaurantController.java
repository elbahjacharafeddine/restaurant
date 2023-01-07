package com.example.backendspring.controller;

import com.example.backendspring.beans.Restaurant;
import com.example.backendspring.repository.RestaurantRepository;
import com.example.backendspring.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService service;
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

    @GetMapping("/delete/{id}")
    void deleteRestaurant(@PathVariable Long id){
        restaurantRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    Restaurant getRestaurantById(@PathVariable Long id){
        return restaurantRepository.getRestaurantById(id);
    }

    @GetMapping("/listar")
    public List<Map<String, Object>> listar(Model model) {
        return service.listar();
    }

    @PostMapping("/agregar")
    public String save(@RequestBody Restaurant p, Model model) {
        int id=service.add(p);
        if(id==0) {
            return "No se pudo Regsitrar!";
        }
        return "Se registró con éxito!";
    }
    @PostMapping("/actualizar/{id}")
    public String save(@RequestBody Restaurant p,@PathVariable long id,Model model) {
        p.setId(id);
        int r=service.edit(p);
        if(r==0) {
            return "No se pudo Actualizar!";
        }
        return "Se actualizó con éxito!";
    }
    @PostMapping("/eliminar/{id}")
    public String delete(@PathVariable int id,Model model) {
        int r=service.delete(id);
        if(r==0) {
            return "Registro No Eliminado!";
        }
        return "Registro Eliminado!";
    }



}
