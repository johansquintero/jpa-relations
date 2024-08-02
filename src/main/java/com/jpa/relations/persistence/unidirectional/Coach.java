package com.jpa.relations.persistence.unidirectional;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Coach_uni")
@Table(name="coaches_uni")
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
