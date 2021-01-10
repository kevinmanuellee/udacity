package com.RESTAPI.bootstrap.Service;

import com.RESTAPI.bootstrap.Entity.Dog;
import com.RESTAPI.bootstrap.Repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogServiceImpl implements DogService {
//    @Autowired
    private DogRepository dogRepository;

    @Override
    public List<Dog> retrieveAllDogs() {
        return (List<Dog>) dogRepository.findAll();
    }

    @Override
    public List<String> retrieveDogBreed() {
        return dogRepository.findDogBreed();
    }

    @Override
    public String retrieveDogBreedById(Long id) {
        return dogRepository.findDogBreedById(id);
    }

    @Override
    public List<String> retrieveDogNames() {
        return dogRepository.findDogNames();
    }
}
