package com.sidroded.database.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="client_id", nullable=false)
    private Client client;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name="from_planet_id")
    private Planet fromPlanet;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name="to_planet_id")
    private Planet toPlanet;
    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

}
