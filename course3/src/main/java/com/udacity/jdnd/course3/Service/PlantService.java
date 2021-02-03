package com.udacity.jdnd.course3.Service;

import com.udacity.jdnd.course3.Entity.Plant;
import org.springframework.stereotype.Service;

@Service
public class PlantService {
    public Plant getPlantByName(String name){
        return new Plant();
    }
}
