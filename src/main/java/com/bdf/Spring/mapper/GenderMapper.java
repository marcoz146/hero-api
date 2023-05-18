package com.bdf.Spring.mapper;

import com.bdf.Spring.bo.GenderBO;
import com.bdf.Spring.controller.dto.GenderDTO;
import com.bdf.Spring.entity.GenderDE;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GenderMapper {

    GenderDTO toDTO(GenderDE genderDE);

    GenderDE toEntity(GenderDTO genderDTO);

    GenderBO toBO(GenderDE genderDE);

    GenderDE BOtoEntity(GenderBO genderBO);
}
