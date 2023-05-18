package com.bdf.Spring.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "hero_powers")
public class HeroPowerDE {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hero_id")
    private HeroEntity hero;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "power_id")
    private PowerDE power;
}
