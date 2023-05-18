package com.bdf.Spring.mapper;

import com.bdf.Spring.bo.UniverseBO;
import com.bdf.Spring.entity.UniverseDE;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UniverseBOMapper {

    UniverseDE toEntity(UniverseBO universeBO);
    UniverseBO toBO(UniverseDE universeDE);
}
