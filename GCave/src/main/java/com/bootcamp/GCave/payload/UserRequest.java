package com.bootcamp.GCave.payload;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserRequest {


    @PositiveOrZero(message = "id must be a number positive")
    private long id;

    @Size(min = 5, max = 100, message = "name must be between 5 and 100 characters")
    private String name;






}
