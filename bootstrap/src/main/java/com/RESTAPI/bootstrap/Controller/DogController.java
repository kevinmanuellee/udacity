package com.RESTAPI.bootstrap.Controller;

import com.RESTAPI.bootstrap.Entity.Dog;
import com.RESTAPI.bootstrap.Service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DogController {
    private DogService dogService;

    @Autowired
    public void setDogService(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping("/dogs")
    public ResponseEntity<List<Dog>> getListOfDogs(){
        List<Dog> list = dogService.retrieveAllDogs();
        return new ResponseEntity<List<Dog>>(list, HttpStatus.OK);
    }

    @GetMapping("/dogs/breed")
    public ResponseEntity<List<String>> getListOfDogBreeds(){
        List<String> list = dogService.retrieveDogBreed();
        return new ResponseEntity<List<String>>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}/breed")
    public ResponseEntity<String> getListOfDogBreedById(@PathVariable Long id){
        String result = dogService.retrieveDogBreedById(id);
        if (result != null){
            return new ResponseEntity<String>(result, HttpStatus.OK);
        }
        return new ResponseEntity<String>(result, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/dogs/name")
    public ResponseEntity<List<String>> getListOfDogNames(){
        List<String> list = dogService.retrieveDogNames();
        return new ResponseEntity<List<String>>(list, HttpStatus.OK);
    }
}
