package com.bdf.Spring.service;

import com.bdf.Spring.bo.PowerBO;
import com.bdf.Spring.entity.PowerDE;
import com.bdf.Spring.exception.BadRequestException;
import com.bdf.Spring.mapper.PowerMapper;
import com.bdf.Spring.repository.PowerRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PowerBOService {

    private final PowerRepository powerRepository;

    private final PowerMapper powerMapper;

    public PowerBOService(PowerRepository powerRepository, PowerMapper powerMapper) {
        this.powerRepository = powerRepository;
        this.powerMapper = powerMapper;
    }

    public Set<PowerBO> stringToPowerBO(Set<String> stringSet) {
        Set<PowerBO> PowerBOSet = new HashSet<>();
        for (String s : stringSet) {
            PowerBO p = getPower(s);
            PowerBOSet.add(p);
        }
        return PowerBOSet;
    }

    public PowerBO getPower(String power) {
        List<PowerDE> powerDEList = powerRepository.findAll();
        Optional<PowerDE> powers = powerDEList.stream()
                .filter(powerDE -> powerDE.getName().equalsIgnoreCase(power))
                .findFirst();
        if(powers.isPresent()){
            return this.powerMapper.entityToBO(powers.get());
        }
        throw new BadRequestException("Power not found");
    }
}
