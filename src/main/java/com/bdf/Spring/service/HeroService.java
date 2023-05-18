package com.bdf.Spring.service;

import com.bdf.Spring.controller.dto.HeroDTO;
import com.bdf.Spring.exception.NotFoundException;
import com.bdf.Spring.mapper.HeroBOMapper;
import com.bdf.Spring.mapper.HeroMapper;
import com.bdf.Spring.repository.HeroRepository;
import com.bdf.Spring.entity.HeroEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class HeroService {

    private final HeroMapper heroMapper;
    private final HeroRepository heroRepository;

    private final HeroBOService heroBOService;

    private final HeroBOMapper heroBOMapper;

    @Autowired
    public HeroService(HeroMapper heroMapper, HeroRepository heroRepository, HeroBOService heroBOService, HeroBOMapper heroBOMapper) {
        this.heroMapper = heroMapper;
        this.heroBOMapper = heroBOMapper;
        this.heroRepository = heroRepository;
        this.heroBOService = heroBOService;
    }

    public List<HeroDTO> allHeroes() {
        return heroRepository.findAll()
                .stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    public HeroDTO entityToDTO(HeroEntity heroEntity) {
        return heroMapper.toDTO(heroEntity);
    }


    public HeroDTO findById(Long id) {
        return this.heroMapper.toDTO(heroRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Did not found a Hero with id " + id)));
    }

    public void deleteById(Long id) {
        heroRepository.delete(heroRepository.findById(id).orElseThrow(() -> new NotFoundException("Did not found a Hero with id " + id)));
    }


    public HeroDTO create(HeroDTO hero) {
//        if (heroAlreadyExists(hero.getNickname()))
//            throw new BadRequestException("Hero already exists");
//        return this.heroMapper.toDTO(heroRepository.save(this.heroMapper.toEntity(hero)));
          return this.heroBOMapper.toDTO(heroBOService.create(this.heroBOMapper.toBO(this.heroMapper.toEntity(hero))));
    }

    public HeroDTO getByName(String name){
        return heroMapper.toDTO(heroRepository.findByName(name));
    }

    private boolean heroAlreadyExists(String name) {
        for (HeroDTO hero : this.allHeroes()) {
            if (hero.getNickname().equals(name))
                return true;
        }
        return false;
    }

//    public List<HeroDTO> getHeroesByUniverse(String name) {
//        return heroBOService.getHeroesByUniverse(name)
//                .stream().map(this.heroBOMapper::toDTO)
//                .collect(Collectors.toList());
//    }
}
