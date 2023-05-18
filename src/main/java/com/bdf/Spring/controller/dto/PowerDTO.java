package com.bdf.Spring.controller.dto;

import lombok.Data;

import java.util.Set;

@Data
public class PowerDTO {
    private Long id;
    private String name;
    private Set<HeroPowerDTO> powers;
}
