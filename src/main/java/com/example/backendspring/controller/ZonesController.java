package com.example.backendspring.controller;

import com.example.backendspring.beans.Zone;
import com.example.backendspring.repository.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/zones")
class ZonesController {
    @Autowired
    ZoneRepository zoneRepository;
    @GetMapping("/all")
    public List<Zone> findAll(){
        return zoneRepository.findAll();
    }


}

