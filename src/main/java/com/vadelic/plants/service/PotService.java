package com.vadelic.plants.service;

import com.vadelic.plants.entity.FlowerPot;
import com.vadelic.plants.entity.Garden;
import com.vadelic.plants.repository.FlowerPotRepository;
import com.vadelic.plants.repository.GardenRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PotService {
    private final GardenRepository gardenRepo;
    private final FlowerPotRepository potRepo;


    public List<FlowerPot> allUsersPots(String login) {
        final List<Garden> usersGardens = gardenRepo.findAllByLogin(login);
        List<FlowerPot> allUsersFlower = potRepo.findAllByGardenIn(usersGardens);
        log.info("User {}, Gardens {}, Flowers {}",login,usersGardens.size(),allUsersFlower.size());
        return allUsersFlower;
    }

    public FlowerPot setFlower(FlowerPot flowerPot) {
        log.info("Added flower {}", flowerPot);
        return potRepo.save(flowerPot);
    }
}
