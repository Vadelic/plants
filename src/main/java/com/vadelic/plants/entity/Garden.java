package com.vadelic.plants.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Garden {
    @Id
    @GeneratedValue
    Long id;
    @Column
    private String login;
    @Column
    private String name;

    public Garden(long id) {
        this.id = id;
    }
}
