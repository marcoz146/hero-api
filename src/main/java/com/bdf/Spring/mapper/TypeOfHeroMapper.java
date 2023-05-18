package com.bdf.Spring.mapper;


import com.bdf.Spring.bo.TypeOfHeroBO;
import com.bdf.Spring.controller.dto.TypeOfHeroDTO;
import com.bdf.Spring.entity.TypeOfHeroDE;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TypeOfHeroMapper {

    TypeOfHeroDTO toDTO(TypeOfHeroDE typeOfHeroDE);

    TypeOfHeroDE toEntity(TypeOfHeroDTO typeOfHeroDTO);

    TypeOfHeroBO toBO(TypeOfHeroDE typeOfHeroDE);

    TypeOfHeroDE BOtoEntity(TypeOfHeroBO typeOfHeroBO);
}
