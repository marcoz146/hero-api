package com.bdf.Spring.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "heroes")
public class HeroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false)
    private String name;

    private String city;

    @ManyToOne
    @JoinColumn(name = "universe_id", referencedColumnName = "id")
    private UniverseDE universe;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "enemy_id", referencedColumnName = "id")
    private EnemyDE enemy;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "alter_ego_id", referencedColumnName = "id")
    private AlterEgoDE alterEgo;

    @Lazy
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hero")
    private Set<HeroPowerDE> heroPower;

    @ManyToOne
    @JoinColumn(name = "gender_id", referencedColumnName = "id")
    private GenderDE heroGender;

    @OneToMany
    @JoinColumn(name = "weakness_id", referencedColumnName = "id")
    private Set<WeaknessDE> heroWeakness;

    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private TypeOfHeroDE typeOfHero;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "partner_id", referencedColumnName = "id")
    private PartnerDE partner;

}
