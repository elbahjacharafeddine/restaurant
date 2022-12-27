package com.example.backendspring.controller;

import com.example.backendspring.beans.Specialite;
import com.example.backendspring.beans.Ville;
import com.example.backendspring.repository.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/all/{id}")
    public ResponseEntity<Ville> getVilleByid(@PathVariable int id){

        Ville ville = villeRepository.findById(id);

        return ResponseEntity.ok(ville);

    }
    @PostMapping("/addVille")
    public Ville AddVille(@RequestBody Ville ville){
        return villeRepository.save(ville);
    }

    //update bill by id
    @PutMapping("/ville/{id}")
    public ResponseEntity<Ville> updateVille(@PathVariable int id,@RequestBody Ville ville){

        Ville existE =villeRepository.findById(id);
        existE.setNom(ville.getNom());
        existE.setZones(ville.getZones());
        villeRepository.save(existE);
        return ResponseEntity.ok(existE);

    }

    //Delete Bill By ID
    @DeleteMapping("/ville/{id}")
    public ResponseEntity<HttpStatus> deleteVille(@PathVariable int id){

        Ville ville = villeRepository.findById(id);

        villeRepository.delete(ville);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


}
