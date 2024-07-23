package com.jpa.relations.persistence.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    private String nationtality;
    private Integer age;
    private String position;

    @ManyToOne(targetEntity = Club.class)
    @JoinColumn(name = "id_club")
    private Club club;
}
