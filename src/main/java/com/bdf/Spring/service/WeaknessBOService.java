package com.bdf.Spring.service;

import com.bdf.Spring.bo.WeaknessBO;
import com.bdf.Spring.entity.WeaknessDE;
import com.bdf.Spring.exception.BadRequestException;
import com.bdf.Spring.mapper.HeroBOMapper;
import com.bdf.Spring.mapper.HeroMapper;
import com.bdf.Spring.mapper.WeaknessMapper;
import com.bdf.Spring.repository.WeaknessRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WeaknessBOService {

    private final WeaknessRepository weaknessRepository;
    private final HeroMapper heroMapper;
    private final HeroBOMapper heroBOMapper;
    private WeaknessMapper weaknessMapper;

    public WeaknessBOService(WeaknessRepository weaknessRepository, HeroMapper heroMapper, HeroBOMapper heroBOMapper, WeaknessMapper weaknessMapper) {
        this.weaknessRepository = weaknessRepository;
        this.heroMapper = heroMapper;
        this.heroBOMapper = heroBOMapper;
        this.weaknessMapper = weaknessMapper;
    }


    public WeaknessBO getWeaknesses(String weaknesses) {
        List<WeaknessDE> weaknessDEList = weaknessRepository.findAll();
        Optional<WeaknessDE> weakness = weaknessDEList.stream()
                .filter(weaknessDE -> weaknessDE.getName().equalsIgnoreCase(weaknesses))
                .findFirst();
        if(weakness.isPresent()){
            return this.weaknessMapper.toBO(weakness.get());
        }
        throw new BadRequestException("Weakness not found");
    }

    public Set<WeaknessBO> stringToWeaknessBO(Set<String> stringSet) {
        Set<WeaknessBO> weaknessBOSet = new HashSet<>();
        for (String s : stringSet) {
            WeaknessBO w = getWeaknesses(s);
            weaknessBOSet.add(w);
        }
        return weaknessBOSet;
    }


}
