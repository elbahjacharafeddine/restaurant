package com.example.backendspring.controller;

import com.example.backendspring.beans.Serie;
import com.example.backendspring.beans.Specialite;
import com.example.backendspring.beans.Ville;
import com.example.backendspring.repository.SerieRepository;
import com.example.backendspring.repository.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/series")
public class SeriesController {
    @Autowired
    SerieRepository serieRepository;
    @GetMapping("/all")
    public List<Serie> findAll(){
        return serieRepository.findAll();
    }
    @GetMapping("/Serie/{id}")
    public ResponseEntity<Serie> getSerieByid(@PathVariable int id){

        Serie serie = serieRepository.findById(id);

        return ResponseEntity.ok(serie);

    }
    @GetMapping("/addSerie")
    public Serie AddSerie(@RequestBody Serie serie){
        return serieRepository.save(serie);
    }

    //update bill by id
    @PutMapping("/Serie/{id}")
    public ResponseEntity<Serie> updateSerie(@PathVariable int id,@RequestBody Serie serie){

        Serie existE =serieRepository.findById(id);
        existE.setNom(serie.getNom());
        serieRepository.save(existE);
        return ResponseEntity.ok(existE);

    }

    //Delete Bill By ID
    @DeleteMapping("/Serie/{id}")
    public ResponseEntity<HttpStatus> deleteBill(@PathVariable int id){

        Serie serie = serieRepository.findById(id);

        serieRepository.delete(serie);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
