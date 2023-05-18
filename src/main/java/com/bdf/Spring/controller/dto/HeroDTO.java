package com.bdf.Spring.controller.dto;


import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Set;


@Data
@ApiModel (value = "HeroDTO", description = "used to represent data about a Hero")
public class HeroDTO {

    private Long id;

    @NotEmpty(message = "can't be empty")
    private String nickname;

    @NotEmpty(message = "can't be empty")
    private String agency;

    private Set<String> powers;

    private Set<String> weaknesses;

    private String type;

    private String rival;

    private String gender;

    private String identity;

    private String location;

    private String sideKick;

}
