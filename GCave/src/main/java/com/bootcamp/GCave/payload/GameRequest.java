package com.bootcamp.GCave.payload;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
public class GameRequest {



    @PositiveOrZero(message = "Game's id must be a number positive")
    private long id;

    @Size(min = 5, max = 100, message = "Game's name must be between 5 and 100 characters")
    private String name;


    @Size(min = 3, max = 100, message = "Game's webDescription must be between 3 and 100 characters")
    private String webDescription;


    @Size(min = 3, max = 100, message = "Game's mobileDescription must be between 3 and 100 characters")
    private String mobileDescription;
}
