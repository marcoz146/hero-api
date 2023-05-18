package com.bdf.Spring.service;

import com.bdf.Spring.controller.dto.GenderDTO;
import com.bdf.Spring.entity.GenderDE;
import com.bdf.Spring.mapper.GenderMapper;
import com.bdf.Spring.repository.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenderService {
    private final GenderRepository genderRepository;
    private final GenderMapper genderMapper;

    private final GenderBOService genderBOService;

    @Autowired
    GenderService(GenderRepository genderRepository, GenderMapper genderMapper, GenderBOService genderBOService){
        this.genderRepository = genderRepository;
        this.genderMapper = genderMapper;
        this.genderBOService = genderBOService;
    }
    public List<GenderDTO> allUniverses() {
        return genderRepository.findAll()
                .stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }
    private GenderDTO entityToDTO(GenderDE genderDE) {
        return genderMapper.toDTO(genderDE);
    }

    public GenderDTO createGender(GenderDTO genderDTO){
        return genderBOService.create(this.genderMapper.toBO(this.genderMapper.toEntity(genderDTO)));
    }

}
