package com.vadelic.plants.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class FlowerPotDTO {
    private Long id;

    private String name;
    private byte water;
    private byte health;

}