package com.bdf.Spring.bo;


import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
public class HeroBO {
    private Long id;

    @NotEmpty(message = "can't be empty")
    private String nickname;

    @NotEmpty(message = "can't be empty")
    private UniverseBO agency;

    private Set<HeroPowerBO> powers;

    private Set<WeaknessBO> weaknesses;

    private TypeOfHeroBO type;

    private EnemyBO rival;

    private GenderBO gender;

    private AlterEgoBO identity;

    private String location;

    private PartnerBO sideKick;
}
