package com.jpa.relations.persistence.unidirectional;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity(name = "Club_uni")
@Table(name = "clubs_uni")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    @ManyToOne(targetEntity = FootballAssociation.class)
    @JoinColumn(name = "football_association")
    private FootballAssociation footballAssociation;

    @OneToMany(targetEntity = Player.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "id_club")
    private Set<Player> playerSet;


    @ManyToMany(targetEntity = Tournament.class,fetch = FetchType.LAZY)
    @JoinTable(
            name = "tournament_club_uni",
            joinColumns = @JoinColumn(name = "club"),
            inverseJoinColumns = @JoinColumn(name = "tournament")
    )
    private Set<Tournament> tournaments;
}
