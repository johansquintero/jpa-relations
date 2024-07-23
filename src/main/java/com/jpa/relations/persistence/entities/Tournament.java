package com.jpa.relations.persistence.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@Table(name = "torunament")
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(name = "start_date",columnDefinition = "DATE")
    private LocalDate startDate;

    @Column(name = "end_date",columnDefinition = "DATE")
    private LocalDate endDate;

    @ManyToMany(targetEntity = Club.class,fetch = FetchType.LAZY, mappedBy = "tournaments")
    private Set<Club> clubs;
}
