package com.jpa.relations.persistence.unidirectional;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Tournament_uni")
@Table(name = "tournament_uni")
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(name = "start_date",columnDefinition = "DATE")
    private LocalDate startDate;

    @Column(name = "end_date",columnDefinition = "DATE")
    private LocalDate endDate;
}
