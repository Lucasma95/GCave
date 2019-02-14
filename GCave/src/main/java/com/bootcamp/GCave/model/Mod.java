package com.bootcamp.GCave.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Table(name="mods")
public class Mod extends Item {


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "games_id")//,referencedColumnName="id"
    //@NotNull(message = "game attribute cannot be null")
    Game game;
}
