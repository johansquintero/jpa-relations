package com.jpa.relations.persistence.bidirectional;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Football_associations_bi")
@Table(name = "football_associations_bi")
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
