package com.bootcamp.GCave.payload;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ModRequest {

    @PositiveOrZero(message = "id must be a number positive")
    private long id;

    @Size(min = 5, max = 100, message = "name must be between 5 and 100 characters")
    private String name;

    @Size(min = 3, max = 100, message = "webDescription must be between 3 and 100 characters")
    private String webDescription;

    @Size(min = 3, max = 100, message = "mobileDescription must be between 3 and 100 characters")
    private String mobileDescription;

    @PositiveOrZero(message = "idGame must be a number positive")
    private Long idGame;


}
