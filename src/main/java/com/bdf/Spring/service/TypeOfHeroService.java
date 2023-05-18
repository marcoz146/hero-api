package com.bdf.Spring.service;

import com.bdf.Spring.controller.dto.TypeOfHeroDTO;
import com.bdf.Spring.entity.TypeOfHeroDE;
import com.bdf.Spring.mapper.TypeOfHeroMapper;
import com.bdf.Spring.repository.TypeOfHeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeOfHeroService {
    private final TypeOfHeroRepository typeOfHeroRepository;
    private final TypeOfHeroMapper typeOfHeroMapper;

    @Autowired
    public TypeOfHeroService(TypeOfHeroRepository typeOfHeroRepository, TypeOfHeroMapper typeOfHeroMapper) {
        this.typeOfHeroRepository = typeOfHeroRepository;
        this.typeOfHeroMapper = typeOfHeroMapper;
    }

    public List<TypeOfHeroDTO> allTypes(){
        return typeOfHeroRepository.findAll()
                .stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    private TypeOfHeroDTO entityToDTO(TypeOfHeroDE typeOfHeroDE) {
        return typeOfHeroMapper.toDTO(typeOfHeroDE);
    }
}
