package com.jpa.relations.persistence.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name = "football_associations")
public class FootballAssociation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;
    private String president;

    @OneToMany(targetEntity = Club.class,fetch = FetchType.LAZY,mappedBy = "footballAssociation")
    private Set<Club> clubs;
}
