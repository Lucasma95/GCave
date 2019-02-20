package com.bootcamp.GCave.payload;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.PositiveOrZero;

@Getter
@Setter
public class TransactionRequest {

    @PositiveOrZero(message = "If you want complete a transaction User's id must be a positive  number")
    Long idUser;
    @PositiveOrZero(message = "If you want complete a transaction Game's id must be a positive  number")
    Long idGame;
    @PositiveOrZero(message = "If you want complete a transaction Mod's id must be a positive  number")
    Long idMod;



}
