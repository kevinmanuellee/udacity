package com.udacity.eureka.Repository;

import com.udacity.eureka.Entity.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Long> {
}
