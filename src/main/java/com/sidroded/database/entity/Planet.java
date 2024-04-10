package com.sidroded.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "planet")
public class Planet {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private String id;

    @Column(name = "name", nullable = false, length = 500)
    private String name;

    @OneToMany(mappedBy="fromPlanet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> fromPlanet  = new ArrayList<>();

    @OneToMany(mappedBy="toPlanet", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ticket> toPlanet = new HashSet<>();

    public Planet() {}

    public Planet(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
