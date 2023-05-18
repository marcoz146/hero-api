package com.bdf.Spring.service;


import com.bdf.Spring.controller.dto.WeaknessDTO;
import com.bdf.Spring.entity.HeroEntity;
import com.bdf.Spring.entity.WeaknessDE;
import com.bdf.Spring.mapper.HeroMapper;
import com.bdf.Spring.mapper.WeaknessMapper;
import com.bdf.Spring.repository.WeaknessRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeaknessService {
    private final WeaknessRepository weaknessRepository;
    private final  WeaknessBOService weaknessBOService;

    private final WeaknessMapper weaknessMapper;

    public WeaknessService(WeaknessRepository weaknessRepository, WeaknessBOService weaknessBOService, WeaknessMapper weaknessMapper) {
        this.weaknessRepository = weaknessRepository;
        this.weaknessBOService = weaknessBOService;
        this.weaknessMapper = weaknessMapper;
    }

    public List<WeaknessDTO> allWeakness() {
        return weaknessRepository.findAll()
                .stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }
    private WeaknessDTO entityToDTO(WeaknessDE weaknessDE) {
        return weaknessMapper.toDTO(weaknessDE);
    }
}
