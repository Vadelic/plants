package com.vadelic.plants.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Plant implements Serializable {
    @Id
    String name;
    String description;
    Integer wateringComfort;
    Integer wateringRisk;

    public Plant(String name) {
        this.name = name;
    }

}