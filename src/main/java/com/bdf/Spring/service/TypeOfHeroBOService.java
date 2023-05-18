package com.bdf.Spring.service;

import com.bdf.Spring.bo.TypeOfHeroBO;
import com.bdf.Spring.entity.TypeOfHeroDE;
import com.bdf.Spring.exception.BadRequestException;
import com.bdf.Spring.mapper.TypeOfHeroMapper;
import com.bdf.Spring.repository.TypeOfHeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeOfHeroBOService {
    private final TypeOfHeroRepository typeOfHeroRepository;
    private final TypeOfHeroMapper typeOfHeroMapper;

    @Autowired
    public TypeOfHeroBOService(TypeOfHeroRepository typeOfHeroRepository, TypeOfHeroMapper typeOfHeroMapper) {
        this.typeOfHeroRepository = typeOfHeroRepository;
        this.typeOfHeroMapper = typeOfHeroMapper;
    }

    public TypeOfHeroBO getType(String name) {
        List<TypeOfHeroDE> typeDEList = typeOfHeroRepository.findAll();
        Optional<TypeOfHeroDE> type = typeDEList.stream()
                .filter(typeDE -> typeDE.getDescription().equalsIgnoreCase(name))
                .findFirst();
        if (type.isPresent()) {
            return this.typeOfHeroMapper.toBO(type.get());
        }
        throw new BadRequestException("Universe not found");
    }


}
