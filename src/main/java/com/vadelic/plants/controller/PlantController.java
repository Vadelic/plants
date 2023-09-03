package com.vadelic.plants.controller;

import com.vadelic.plants.dto.PlantDTO;
import com.vadelic.plants.entity.Plant;
import com.vadelic.plants.service.DTOMappingService;
import com.vadelic.plants.service.PlantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/plant")
@RequiredArgsConstructor
public class PlantController {
    private final PlantService plantService;
    private final DTOMappingService mappingService;


    @GetMapping("/")
    public List<PlantDTO> allPlants() {
        List<Plant> all = plantService.all();

        return mappingService.map(all, PlantDTO.class);
    }
}
