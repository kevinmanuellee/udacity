package com.udacity.jdnd.course3.Controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.udacity.jdnd.course3.DTO.PlantDTO;
import com.udacity.jdnd.course3.DTO.Views;
import com.udacity.jdnd.course3.Entity.Plant;
import com.udacity.jdnd.course3.Service.PlantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plant")
public class PlantController {

    @Autowired
    private PlantService plantService;

    public PlantDTO getPlantDTO(String name){
        Plant plant = plantService.getPlantByName(name);
        PlantDTO plantDTO = convertEntityToPlantDTO(plant);
        return plantDTO;
    }

    @JsonView(Views.Public.class)
    public Plant getFilteredPlant(String name){
        return plantService.getPlantByName(name);
    }

    private static PlantDTO convertEntityToPlantDTO (Plant plant){
        PlantDTO plantDTO = new PlantDTO();
        BeanUtils.copyProperties(plant, plantDTO);
        return plantDTO;
    }

    private static Plant convertPlantDTOToEntity (PlantDTO plantDTO){
        Plant plant = new Plant();
        BeanUtils.copyProperties(plantDTO, plant);
        return plant;
    }
}
