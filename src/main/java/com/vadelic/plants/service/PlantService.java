package com.vadelic.plants.service;

import com.vadelic.plants.entity.Plant;
import com.vadelic.plants.repository.PlantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlantService {
    private final PlantRepository plantRepo;

    public List<Plant> all() {
        List<Plant> all = plantRepo.findAll();
        log.info("Plants in catalog count:{}", all.size());
        return all;
    }

    public Plant getPlant(String plantName) {
        Plant plant = plantRepo.findById(plantName)
                .orElseThrow(() -> new NoSuchElementException("No plant present with name " + plantName));
        log.info("Fount plant by name: {}", plant);
        return plant;
    }
}
