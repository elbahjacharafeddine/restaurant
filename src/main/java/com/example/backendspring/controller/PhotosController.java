package com.example.backendspring.controller;

import com.example.backendspring.beans.Photo;
import com.example.backendspring.beans.Serie;
import com.example.backendspring.beans.Specialite;
import com.example.backendspring.repository.PhotoRepository;
import com.example.backendspring.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Photos")
public class PhotosController {
    @Autowired
    PhotoRepository photoRepository;
    @GetMapping("/all")
    public List<Photo> findAll(){
        return photoRepository.findAll();
    }

    @GetMapping("/Photo/{id}")
    public ResponseEntity<Photo> getPhotoByid(@PathVariable int id){

        Photo photo = photoRepository.findById(id);

        return ResponseEntity.ok(photo);

    }
    @GetMapping("/addPhoto")
    public Photo AddSpeciality(@RequestBody Photo photo){
        return photoRepository.save(photo);
    }

    //update bill by id
    @PutMapping("/Photo/{id}")
    public ResponseEntity<Photo> updatePhoto(@PathVariable int id,@RequestBody Photo photo){

        Photo existE =photoRepository.findById(id);
        existE.setUrl(photo.getUrl());
        photoRepository.save(existE);
        return ResponseEntity.ok(existE);

    }

    //Delete Photo By ID
    @DeleteMapping("/Photo/{id}")
    public ResponseEntity<HttpStatus> deleteBill(@PathVariable int id){

        Photo photo = photoRepository.findById(id);

        photoRepository.delete(photo);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


}
