package com.bdf.Spring.mapper;

import com.bdf.Spring.bo.PowerBO;
import com.bdf.Spring.controller.dto.PowerDTO;
import com.bdf.Spring.entity.HeroEntity;
import com.bdf.Spring.entity.PowerDE;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface PowerMapper {
    PowerDTO toDTO(PowerDE powerDE);

    PowerDE toEntity(PowerDTO powerDTO);



    default PowerDE stringToPower(String power) {
        PowerDE p = new PowerDE();
        p.setName(power);
        return p;
    }

    default String powerToString(PowerDE power){
        return power.getName();
    }

    default String heroToString(HeroEntity hero) {
        return hero.getName();
    }

    default HeroEntity stringToHero(String name){
        HeroEntity h = new HeroEntity();
        h.setName(name);
        return h;
    }

    default PowerBO entityToBO(PowerDE powerDE){
        PowerBO powerBO = new PowerBO();
        powerBO.setId(powerDE.getId());
        powerBO.setName(powerDE.getName());
        powerBO.setPowers(null);
        return powerBO;
    }
}
