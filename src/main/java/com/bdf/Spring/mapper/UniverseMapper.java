package com.bdf.Spring.mapper;

import com.bdf.Spring.controller.dto.UniverseDTO;
import com.bdf.Spring.entity.UniverseDE;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UniverseMapper {

    UniverseDE toEntity(UniverseDTO universeDTO);

    UniverseDTO toDTO(UniverseDE universeDE);


}
