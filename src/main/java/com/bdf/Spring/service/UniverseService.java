package com.bdf.Spring.service;

import com.bdf.Spring.controller.dto.UniverseDTO;
import com.bdf.Spring.entity.UniverseDE;
import com.bdf.Spring.mapper.UniverseBOMapper;
import com.bdf.Spring.mapper.UniverseMapper;
import com.bdf.Spring.repository.UniverseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UniverseService {

    private final UniverseBOService serviceUniverseBO;
    private final UniverseRepository universeRepository;
    private final UniverseBOMapper universeBOMapper;
    private final UniverseMapper universeMapper;

    @Autowired
    UniverseService(UniverseBOService serviceUniverseBO, UniverseRepository universeRepository, UniverseMapper universeMapper, UniverseBOMapper universeBOMapper){
        this.serviceUniverseBO = serviceUniverseBO;
        this.universeRepository = universeRepository;
        this.universeMapper = universeMapper;
        this.universeBOMapper = universeBOMapper;
    }

    public List<UniverseDTO> allUniverses() {
        return universeRepository.findAll()
                .stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    private UniverseDTO entityToDTO(UniverseDE universeDE) {
        return universeMapper.toDTO(universeDE);
    }

    public UniverseDTO createUniverse(UniverseDTO universeDTO){
        return serviceUniverseBO.create(this.universeBOMapper.toBO(this.universeMapper.toEntity(universeDTO)));
    }
}
