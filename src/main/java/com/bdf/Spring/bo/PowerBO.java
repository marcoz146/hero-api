package com.bdf.Spring.bo;


import lombok.Data;

import java.util.Set;

@Data
public class PowerBO {
    private Long id;
    private String name;
    private Set<HeroPowerBO> powers;
}
