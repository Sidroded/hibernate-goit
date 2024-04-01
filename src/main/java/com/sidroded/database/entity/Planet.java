package com.sidroded.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "planet")
public class Planet {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private String id;
    @Column(name = "name", nullable = false, length = 500)
    private String name;
}
