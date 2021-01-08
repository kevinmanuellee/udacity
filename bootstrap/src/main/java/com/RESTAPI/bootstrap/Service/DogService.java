package com.RESTAPI.bootstrap.Service;

import com.RESTAPI.bootstrap.Entity.Dog;
import com.RESTAPI.bootstrap.Repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DogService {

    List<Dog> retrieveAllDogs();
    List<String> retrieveDogBreed();
    String retrieveDogBreedById(Long id);
    List<String> retrieveDogNames();

}
