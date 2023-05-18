package com.bdf.Spring.bo;

import lombok.Data;

@Data

public class HeroPowerBO {
    private Long id;
    private HeroBO hero;
    private PowerBO power;
}
