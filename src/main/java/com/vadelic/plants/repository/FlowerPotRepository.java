package com.vadelic.plants.repository;

import com.vadelic.plants.entity.FlowerPot;
import com.vadelic.plants.entity.Garden;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlowerPotRepository extends JpaRepository<FlowerPot, Long> {
        List<FlowerPot> findAllByGardenIn(List<Garden> garden);
}