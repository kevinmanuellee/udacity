package com.udacity.DogGraphQL.Repository;

import com.udacity.DogGraphQL.Entity.Dog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface DogRepository extends CrudRepository<Dog, Long> {
}
