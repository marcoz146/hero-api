package com.bdf.Spring.mapper;

import com.bdf.Spring.controller.dto.HeroDTO;
import com.bdf.Spring.entity.HeroEntity;
import com.bdf.Spring.entity.HeroPowerDE;
import com.bdf.Spring.entity.PowerDE;
import com.bdf.Spring.entity.WeaknessDE;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import java.util.Set;


@Mapper(componentModel = "spring")
public interface HeroMapper {

    @Mapping(target = "nickname", source = "name")
    @Mapping(target = "type", source = "typeOfHero.description")
    @Mapping(target = "rival", source = "enemy.name")
    @Mapping(target = "agency", source = "universe.description")
    @Mapping(target = "gender", source = "heroGender.description")
    @Mapping(target = "powers", source = "heroPower")
    @Mapping(target = "weaknesses", source = "heroWeakness")
    @Mapping(target = "identity", source = "alterEgo.name")
    @Mapping(target = "location", source = "city")
    @Mapping(target = "sideKick", source = "partner.name")
    HeroDTO toDTO(HeroEntity heroEntity);

    @Mapping(target = "name", source = "nickname")
    @Mapping(target = "typeOfHero.description", source = "type")
    @Mapping(target = "enemy.name", source = "rival")
    @Mapping(target = "universe.description", source = "agency")
    @Mapping(target = "heroGender.description", source = "gender")
    @Mapping(target = "heroPower", source = "powers")
    @Mapping(target = "heroWeakness", source = "weaknesses")
    @Mapping(target = "alterEgo.name", source = "identity")
    @Mapping(target = "city", source = "location")
    @Mapping(target = "partner.name", source = "sideKick")
    HeroEntity toEntity(HeroDTO heroDTO);


    Set<String> weaknessToString(Set<WeaknessDE> weaknessDESet);

    default String BOtoString(WeaknessDE weaknessDE) {
        return weaknessDE.getName();
    }

    Set<WeaknessDE> stringToWeakness(Set<String> weakness);

    default WeaknessDE stringToWeakness(String weakness) {
        WeaknessDE w = new WeaknessDE();
        w.setName(weakness);
        return w;
    }

    Set<String> powerDEtoString(Set<HeroPowerDE> heroPowerDE);

    default String powerDEtoString(HeroPowerDE heroPowerDE){
        return heroPowerDE.getPower().getName();
    }

    Set<HeroPowerDE> stringToHeroPowerDE(Set<String> powers);

    default HeroPowerDE stringToHeroPowerDE(String power){
        HeroPowerDE hp = new HeroPowerDE();
        PowerDE p = new PowerDE();
        p.setName(power);
        hp.setPower(p);

        return hp;
    }
}
