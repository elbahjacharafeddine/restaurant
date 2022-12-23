package com.example.backendspring.controller;

import com.example.backendspring.beans.Ville;
import com.example.backendspring.repository.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/villes")
class VillesController {
    @Autowired
    VilleRepository villeRepository;
    @GetMapping("/all")
    public List<Ville> findAll(){
        return villeRepository.findAll();
    }


}
