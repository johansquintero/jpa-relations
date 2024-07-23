package com.jpa.relations.persistence.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="coaches")
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    private Integer age;
    private String nationality;

    @OneToOne(targetEntity = Club.class)
//  @JoinColumn(name = "id_club")
    private Club club;
}
