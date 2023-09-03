package com.vadelic.plants.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class FlowerPot implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "fk_pot_garden"))
    private Garden garden;
    @ManyToOne
    @JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "fk_pot_plant"))
    private Plant plant;
    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    @Column(columnDefinition = "bytea")
    private byte[] content;

    @Column(name = "watering")
    private LocalDateTime lastWatering;

    @CreationTimestamp
    @Column(name = "create_at")
    private Timestamp createAt;

    public FlowerPot(Garden garden, Plant plant) {
        this.garden = garden;
        this.plant = plant;
    }
}