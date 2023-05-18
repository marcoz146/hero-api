package com.bdf.Spring.service;

import com.bdf.Spring.bo.GenderBO;
import com.bdf.Spring.controller.dto.GenderDTO;
import com.bdf.Spring.entity.GenderDE;
import com.bdf.Spring.exception.BadRequestException;
import com.bdf.Spring.mapper.GenderMapper;
import com.bdf.Spring.repository.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenderBOService {
    private final GenderRepository genderRepository;
    private final GenderMapper genderMapper;

    @Autowired
    public GenderBOService(GenderRepository genderRepository, GenderMapper genderMapper) {
        this.genderRepository = genderRepository;
        this.genderMapper = genderMapper;
    }
    public GenderDTO create(GenderBO gender) {
        return this.genderMapper.toDTO(genderRepository.save(this.genderMapper.BOtoEntity(gender)));
    }

    public GenderBO getGender(String name) {
        List<GenderDE> genderDEList = genderRepository.findAll();
        Optional<GenderDE> gender = genderDEList.stream()
                .filter(genderDE -> genderDE.getDescription().equalsIgnoreCase(name))
                .findFirst();
        if (gender.isPresent()) {
            return this.genderMapper.toBO(gender.get());
        }
        throw new BadRequestException("Gender not found");
    }
}
