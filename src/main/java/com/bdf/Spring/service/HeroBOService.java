package com.bdf.Spring.service;

import com.bdf.Spring.bo.HeroBO;
import com.bdf.Spring.bo.HeroPowerBO;
import com.bdf.Spring.entity.HeroEntity;
import com.bdf.Spring.entity.HeroPowerDE;
import com.bdf.Spring.exception.BadRequestException;
import com.bdf.Spring.mapper.HeroBOMapper;
import com.bdf.Spring.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class HeroBOService {
    private final HeroBOMapper heroBOMapper;
    private final HeroRepository heroRepository;
    private final UniverseBOService universeBOService;
    private final GenderBOService genderBOService;
    private final TypeOfHeroBOService typeOfHeroBOService;
    private final WeaknessBOService weaknessBOService;
    private final PowerBOService powerBOService;

    @Autowired
    public HeroBOService(HeroBOMapper heroBOMapper, HeroRepository heroRepository, UniverseBOService universeBOService, GenderBOService genderBOService, TypeOfHeroBOService typeOfHeroBOService, WeaknessBOService weaknessBOService, PowerBOService powerBOService) {
        this.heroBOMapper = heroBOMapper;
        this.heroRepository = heroRepository;
        this.universeBOService = universeBOService;
        this.genderBOService = genderBOService;
        this.typeOfHeroBOService = typeOfHeroBOService;
        this.weaknessBOService = weaknessBOService;
        this.powerBOService = powerBOService;
    }

    public HeroBO create(HeroBO hero) {
        if (heroAlreadyExists(hero.getNickname()))
            throw new BadRequestException("Hero already exists");
        hero.setAgency(universeBOService.getUniverse(this.heroBOMapper.toDTO(hero).getAgency()));
        hero.setGender(genderBOService.getGender(this.heroBOMapper.toDTO(hero).getGender()));
        hero.setType(typeOfHeroBOService.getType(this.heroBOMapper.toDTO(hero).getType()));
        hero.setWeaknesses(weaknessBOService.stringToWeaknessBO(this.heroBOMapper.toDTO(hero).getWeaknesses()));

        Set<HeroPowerBO> set = new HashSet<>();
        for (HeroPowerBO power :
                hero.getPowers()) {
            power.setPower(powerBOService.getPower(power.getPower().getName()));
            set.add(power);
        }
        hero.setPowers(set);

        HeroEntity heroEntity = this.heroBOMapper.toEntity(hero);

        for (HeroPowerDE powerDE:
             heroEntity.getHeroPower()) {
                powerDE.setHero(heroEntity);
        }

        return this.heroBOMapper.toBO(heroRepository.save(heroEntity));
    }


    private boolean heroAlreadyExists(String name) {
        for (HeroBO hero : this.allHeroes()) {
            if (hero.getNickname().equalsIgnoreCase(name))
                return true;
        }
        return false;
    }

    public HeroBO entityToBO(HeroEntity heroEntity) {
        return heroBOMapper.toBO(heroEntity);
    }

    public List<HeroBO> allHeroes() {
        return heroRepository.findAll()
                .stream()
                .map(this::entityToBO)
                .collect(Collectors.toList());
    }

    public List<HeroBO> getHeroesByUniverse(String name) {
        return heroRepository.findByUniverse(name)
                .stream().map(this.heroBOMapper::toBO)
                .collect(Collectors.toList());
    }
}
