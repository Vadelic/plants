package com.vadelic.plants.repository;

import com.vadelic.plants.entity.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantRepository extends JpaRepository<Plant, String> {
}