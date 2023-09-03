package com.vadelic.plants.controller;

import com.vadelic.plants.dto.PlantDTO;
import com.vadelic.plants.entity.Plant;
import com.vadelic.plants.service.DTOMappingService;
import com.vadelic.plants.service.PlantService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {

    @GetMapping()
    public OAuth2User allPlants(@AuthenticationPrincipal OAuth2User principal) {

        return principal;
    }
}
