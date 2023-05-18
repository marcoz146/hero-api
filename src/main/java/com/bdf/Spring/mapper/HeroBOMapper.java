package com.bdf.Spring.mapper;

import com.bdf.Spring.bo.HeroBO;
import com.bdf.Spring.bo.HeroPowerBO;
import com.bdf.Spring.bo.PowerBO;
import com.bdf.Spring.bo.WeaknessBO;
import com.bdf.Spring.controller.dto.HeroDTO;
import com.bdf.Spring.entity.HeroEntity;
import com.bdf.Spring.entity.HeroPowerDE;
import com.bdf.Spring.entity.PowerDE;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface HeroBOMapper {
    @Mapping(target = "name", source = "nickname")
    @Mapping(target = "typeOfHero.description", source = "type.description")
    @Mapping(target = "enemy.name", source = "rival.name")
    @Mapping(target = "universe.description", source = "agency.description")
    @Mapping(target = "heroGender.description", source = "gender.description")
    @Mapping(target = "heroPower", source = "powers")
    @Mapping(target = "heroWeakness", source = "weaknesses")
    @Mapping(target = "alterEgo.name", source = "identity.name")
    @Mapping(target = "city", source = "location")
    @Mapping(target = "partner.name", source = "sideKick.name")
    HeroEntity toEntity(HeroBO heroBO);

    @Mapping(target = "nickname", source = "name")
    @Mapping(target = "type.description", source = "typeOfHero.description")
    @Mapping(target = "rival.name", source = "enemy.name")
    @Mapping(target = "agency.description", source = "universe.description")
    @Mapping(target = "gender.description", source = "heroGender.description")
    @Mapping(target = "powers", source = "heroPower")
    @Mapping(target = "weaknesses", source = "heroWeakness")
    @Mapping(target = "identity.name", source = "alterEgo.name")
    @Mapping(target = "location", source = "city")
    @Mapping(target = "sideKick.name", source = "partner.name")
    HeroBO toBO(HeroEntity heroBO);

    @Mapping(target = "agency", source = "agency.description")
    @Mapping(target = "gender", source = "gender.description")
    @Mapping(target = "type", source = "type.description")
    @Mapping(target = "rival", source = "rival.name")
    @Mapping(target = "identity", source = "identity.name")
    @Mapping(target = "sideKick", source = "sideKick.name")
    HeroDTO toDTO(HeroBO heroBO);

    Set<String> weaknessBOToString(Set<WeaknessBO> weaknessBOSet);

    default String weaknessBOtoString(WeaknessBO weaknessBO) {
        return weaknessBO.getName();
    }

    Set<String> heroPowerBOToString(Set<HeroPowerBO> powers);

    default String heroPowerBOtoString(HeroPowerBO heroPowerBO){
        return heroPowerBO.getPower().getName();
    }

    Set<String> heroPowerDEtoString(Set<HeroPowerDE> heroPowerDE);

    default String heroPowerDEtoString(HeroPowerDE heroPowerDE){
        return heroPowerDE.getPower().getName();
    }

    Set<HeroPowerDE> heroPowerBOToHeroPowerDE(Set<HeroPowerBO> powers);
    default HeroPowerDE heroPowerBOToHeroPowerDE(HeroPowerBO heroPower){
        HeroPowerDE hp = new HeroPowerDE();
        PowerDE p = new PowerDE();
        p.setName(heroPower.getPower().getName());
        p.setId(heroPower.getPower().getId());
        hp.setPower(p);
        return hp;
    }

    Set<HeroPowerBO> heroPowerDEToHeroPowerBO(Set<HeroPowerDE> powers);

    default HeroPowerBO heroPowerDEToHeroPowerBO(HeroPowerDE heroPower){
        HeroPowerBO hp = new HeroPowerBO();
        PowerBO p = new PowerBO();
        p.setName(heroPower.getPower().getName());
        p.setId(heroPower.getPower().getId());
        hp.setPower(p);
        
        return hp;
    }
}
