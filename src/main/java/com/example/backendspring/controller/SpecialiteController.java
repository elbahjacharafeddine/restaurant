package com.example.backendspring.controller;

import com.example.backendspring.beans.Specialite;
import com.example.backendspring.beans.Ville;
import com.example.backendspring.repository.SpecialiteRepository;
import com.example.backendspring.repository.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SpecialiteController {
    @Autowired
    SpecialiteRepository specialiteRepository;
    @GetMapping("/all")
    public List<Specialite> findAll(){
        return specialiteRepository.findAll();
    }
    @GetMapping("/all/{id}")
    public ResponseEntity<Specialite> getSpecialicityByid(@PathVariable int id){

        Specialite specialite = specialiteRepository.findById(id);

        return ResponseEntity.ok(specialite);

    }
    @GetMapping("/addSpeciality")
    public Specialite AddSpeciality(@RequestBody Specialite specialite){
        return specialiteRepository.save(specialite);
    }

    //update bill by id
    @PutMapping("/specialite/{id}")
    public ResponseEntity<Specialite> updateSpecialite(@PathVariable int id,@RequestBody Specialite specialite){

        Specialite existE =specialiteRepository.findById(id);
        existE.setNom(specialite.getNom());
        specialiteRepository.save(existE);
        return ResponseEntity.ok(existE);

    }

    //Delete Bill By ID
    @DeleteMapping("/Specialite/{id}")
    public ResponseEntity<HttpStatus> deleteBill(@PathVariable int id){

        Specialite specialite = specialiteRepository.findById(id);

        specialiteRepository.delete(specialite);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }



}
