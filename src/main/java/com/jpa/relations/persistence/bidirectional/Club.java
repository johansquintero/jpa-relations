package com.jpa.relations.persistence.bidirectional;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity(name = "Club_bi")
@Table(name = "clubs_bi")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
            name = "tournament_club_bi",
            joinColumns = @JoinColumn(name = "club"),
            inverseJoinColumns = @JoinColumn(name = "tournament")
    )
    private Set<Tournament> tournaments;
}
