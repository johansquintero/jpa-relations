package com.jpa.relations.persistence.bidirectional;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Coach_bi")
@Table(name="coaches_bi")
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
