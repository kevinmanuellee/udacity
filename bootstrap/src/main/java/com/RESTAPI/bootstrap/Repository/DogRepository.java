package com.RESTAPI.bootstrap.Repository;

import com.RESTAPI.bootstrap.Entity.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DogRepository extends CrudRepository<Dog, Long> {

    @Query("SELECT d.breed FROM Dog d")
    List<String> findDogBreed();

    @Query("SELECT d.breed FROM Dog d WHERE d.id=:id")
    String findDogBreedById(Long id);

    @Query("SELECT d.name FROM Dog d")
    List<String> findDogNames();
}
