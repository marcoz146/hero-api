package com.bdf.Spring.service;

import com.bdf.Spring.bo.UniverseBO;
import com.bdf.Spring.controller.dto.UniverseDTO;
import com.bdf.Spring.entity.UniverseDE;
import com.bdf.Spring.exception.BadRequestException;
import com.bdf.Spring.mapper.UniverseBOMapper;
import com.bdf.Spring.mapper.UniverseMapper;
import com.bdf.Spring.repository.UniverseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UniverseBOService {
    private final UniverseRepository universeRepository;
    private final UniverseMapper universeMapper;
    private final UniverseBOMapper universeBOMapper;

    @Autowired
    UniverseBOService(UniverseRepository universeRepository, UniverseMapper universeMapper, UniverseBOMapper universeBOMapper) {
        this.universeRepository = universeRepository;
        this.universeBOMapper = universeBOMapper;
        this.universeMapper = universeMapper;
    }

    public UniverseDTO create(UniverseBO universe) {
        if (universeAlreadyExists(universe.getDescription()))
            throw new BadRequestException("Universe already exists");
        return this.universeMapper.toDTO(universeRepository.save(this.universeBOMapper.toEntity(universe)));
    }

    public UniverseBO getUniverse(String name) {
        List<UniverseDE> universeDEList = universeRepository.findAll();
        Optional<UniverseDE> universe = universeDEList.stream()
                .filter(universeDE -> universeDE.getDescription().equalsIgnoreCase(name))
                .findFirst();
        if (universe.isPresent()) {
            return this.universeBOMapper.toBO(universe.get());
        }
        throw new BadRequestException("Universe not found");
    }

    private boolean universeAlreadyExists(String name) {
        for (UniverseBO universeBO : this.allUniverses()) {
            if (universeBO.getDescription().equalsIgnoreCase(name))
                return true;
        }
        return false;
    }

    public List<UniverseBO> allUniverses() {
        return universeRepository.findAll()
                .stream()
                .map(this::entityToBO)
                .collect(Collectors.toList());
    }
    public UniverseBO entityToBO(UniverseDE universeEntity) {
        return universeBOMapper.toBO(universeEntity);
    }
}
