package com.example.backendspring.controller;

import com.example.backendspring.beans.Photo;
import com.example.backendspring.beans.Serie;
import com.example.backendspring.repository.PhotoRepository;
import com.example.backendspring.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class PhotosController {
    @Autowired
    PhotoRepository photoRepository;
    @GetMapping("/all")
    public List<Photo> findAll(){
        return photoRepository.findAll();
    }
}
