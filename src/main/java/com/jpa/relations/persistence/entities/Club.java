package com.jpa.relations.persistence.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "clubs")
@Data
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(targetEntity = Player.class,mappedBy = "club",fetch = FetchType.LAZY)
    private Set<Player> playerSet;

    @ManyToOne(targetEntity = FootballAssociation.class)
    private FootballAssociation footballAssociation;

    @ManyToMany(targetEntity = Tournament.class,fetch = FetchType.LAZY)
    @JoinTable(
            name = "tournament_club",
            joinColumns = @JoinColumn(name = "club"),
            inverseJoinColumns = @JoinColumn(name = "tournament")
    )
    private Set<Tournament> tournaments;
}
