package com.bdf.Spring.mapper;

import com.bdf.Spring.bo.WeaknessBO;
import com.bdf.Spring.controller.dto.WeaknessDTO;
import com.bdf.Spring.entity.WeaknessDE;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WeaknessMapper {


    WeaknessDE toEntity(WeaknessDTO weaknessDTO);

    WeaknessDTO toDTO(WeaknessDE weaknessDE);

    WeaknessBO toBO(WeaknessDE weaknessDE);
}
