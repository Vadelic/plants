package com.vadelic.plants.service;

import com.vadelic.plants.entity.Garden;
import com.vadelic.plants.repository.GardenRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class GardenService {
    private final GardenRepository gardenRepo;

    public List<Garden> findGardens(String login) {
//        final String login;
//        if (principal != null) {
//            login = principal.getAttribute("login");
//        } else {
//            login = "Demo";
//        }
        return gardenRepo.findAllByLogin(login);
    }

    public Garden addGarden(Garden garden) {
        return gardenRepo.save(garden);
    }

    public Garden getDefaultGarden(String login) {
        final List<Garden> allByLogin = gardenRepo.findAllByLogin(login);
        if (allByLogin.isEmpty()) {
            final Garden garden = new Garden();
            garden.setLogin(login);
            garden.setName("My garden");
            log.info("Gardens not found. Was created default: {}", garden);
            return gardenRepo.save(garden);
        } else {
            Garden garden = allByLogin.get(0);
            log.info("Found garden: {}",garden);
            return garden;
        }
    }
}
