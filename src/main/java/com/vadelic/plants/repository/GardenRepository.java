package com.vadelic.plants.repository;

import com.vadelic.plants.entity.Garden;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GardenRepository extends JpaRepository<Garden, Long> {

    List<Garden> findAllByLogin(String login);

}