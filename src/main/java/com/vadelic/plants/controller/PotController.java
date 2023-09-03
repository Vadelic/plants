package com.vadelic.plants.controller;

import com.vadelic.plants.dto.FlowerPotDTO;
import com.vadelic.plants.entity.FlowerPot;
import com.vadelic.plants.entity.Garden;
import com.vadelic.plants.entity.Plant;
import com.vadelic.plants.service.DTOMappingService;
import com.vadelic.plants.service.GardenService;
import com.vadelic.plants.service.PlantService;
import com.vadelic.plants.service.PotService;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/pot")
@RequiredArgsConstructor
public class PotController {
    private final PotService potService;
    private final GardenService gardenService;
    private final PlantService plantService;
    private final DTOMappingService mappingService;

    @GetMapping()
    public List<FlowerPotDTO> usersPots(@AuthenticationPrincipal OAuth2User principal) {
        final List<FlowerPot> flowerPots = potService.allUsersPots(principal.getName());
        return mappingService.map(flowerPots, FlowerPotDTO.class);
    }


    @PostMapping()
    public FlowerPotDTO addFlower(@AuthenticationPrincipal OAuth2User principal,
                                  @RequestParam(value = "flower") String plantName,
                                  @RequestParam(value = "garden", required = false) Long gardenId,
                                  @RequestBody(required = false) byte[] photo) {
        final Garden garden = geUserstGarden(principal.getName(), gardenId);
        final Plant plant = plantService.getPlant(plantName);
        FlowerPot flowerPot = new FlowerPot(garden, plant);

        flowerPot = potService.setFlower(flowerPot);
        return mappingService.map(flowerPot, FlowerPotDTO.class);
    }

    private Garden geUserstGarden(String login, @Nullable Long gardenId) {
        if (gardenId != null) {
            return gardenService.findGardens(login).stream()
                    .filter(g -> Objects.equals(gardenId, g.getId()))
                    .findFirst().orElseThrow();
        } else {
            return gardenService.getDefaultGarden(login);
        }
    }

//    @PostMapping("/{id}/water")
//    public FlowerPotDTO putWater(@AuthenticationPrincipal OAuth2User principal,
//                                 @PathVariable(value = "id") Long potId) {
//        FlowerPot flowerPot = potService.allUsersPots(principal.getName()).stream()
//                .filter(f -> Objects.equals(f.getId(), potId))
//                .findFirst().orElseThrow();
//        flowerPot.setLastWatering(LocalDateTime.now());
//
//        flowerPot = potService.setFlower(flowerPot);
//        return mappingService.map(flowerPot, FlowerPotDTO.class);
//    }
}
