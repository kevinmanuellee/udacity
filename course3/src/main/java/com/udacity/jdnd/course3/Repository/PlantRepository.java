package com.udacity.jdnd.course3.Repository;

import com.udacity.jdnd.course3.Entity.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantRepository extends JpaRepository<Plant, Long> {
}
