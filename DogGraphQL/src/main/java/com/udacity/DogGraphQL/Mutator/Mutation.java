package com.udacity.DogGraphQL.Mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.udacity.DogGraphQL.Entity.Dog;
import com.udacity.DogGraphQL.Exception.BreedNotFoundException;
import com.udacity.DogGraphQL.Exception.DogNotFoundException;
import com.udacity.DogGraphQL.Repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {
    private DogRepository dogRepository;

    public Mutation(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Boolean deleteDogBreed(String breed){
        boolean deleted = false;
        Iterable<Dog> allDogs = dogRepository.findAll();

        for(Dog d : allDogs) {
            if (d.getBreed() == breed) {
                d.setBreed("");
                deleted = true;
            }
        }

        if(deleted == false) {
            throw new BreedNotFoundException("Breed Not Found", breed);
        }
        return deleted;
    }

    public Dog updateDogName(Long id, String newName){
        Optional<Dog> optionalDog = dogRepository.findById(id);
        if(optionalDog.isPresent()){
            Dog dog = optionalDog.get();
            dog.setName(newName);
            return dogRepository.save(dog);
        } else {
            throw new DogNotFoundException("Dog Not Found", id);
        }
    }
}
