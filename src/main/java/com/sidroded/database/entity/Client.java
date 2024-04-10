package com.sidroded.database.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "name", length = 200)
    private String name;

    @OneToMany(mappedBy ="client", cascade = CascadeType.ALL)
    private List<Ticket> tickets = new ArrayList<>();

    public Client() {}

    public Client(String name) {
        this.name = name;
    }
}
