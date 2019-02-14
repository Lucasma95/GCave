package com.bootcamp.GCave.payload;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ModRequest {

    private long id;

    private String name;


    private String webDescription;


    private String mobileDescription;


    private Long game;


}
