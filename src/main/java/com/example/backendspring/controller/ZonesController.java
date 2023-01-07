package com.example.backendspring.controller;

import com.example.backendspring.beans.Ville;
import com.example.backendspring.beans.Zone;
import com.example.backendspring.repository.ZoneRepository;
import com.example.backendspring.services.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zones")
class ZonesController {
    @Autowired
    ZoneRepository zoneRepository;

    @Autowired
    ZoneService zoneService;
    @GetMapping("/all")
    public List<Zone> findAll(){
        return zoneRepository.findAll();
    }
    @GetMapping("/all/{id}")
    public ResponseEntity<Zone> getZoneByid(@PathVariable int id){

        Zone zone = zoneRepository.findById(id);

        return ResponseEntity.ok(zone);

    }
    @GetMapping("/zone/{ville_id}")
    public ResponseEntity<List<Zone>> getZonesByVille(@PathVariable(value="ville_id") int ville_id){
        try{
            List<Zone> zones = zoneService.getZonesByVille(ville_id);
            return new ResponseEntity<List<Zone>>(zones, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/addzone")
    public Zone AddZone(@RequestBody Zone zone){
        return zoneRepository.save(zone);
    }

    //update bill by id
    @PutMapping("/zone/{id}")
    public ResponseEntity<Zone> updateZone(@PathVariable int id,@RequestBody Zone zone){

        Zone existE =zoneRepository.findById(id);
        existE.setNom(zone.getNom());

        zoneRepository.save(existE);
        return ResponseEntity.ok(existE);

    }

    //Delete Bill By ID
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteZone(@PathVariable int id){

        Zone zone = zoneRepository.findById(id);

        zoneRepository.delete(zone);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


}

