package com.bootcamp.GCave.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Set;


@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Table(name="games")
public class Game extends  Item {


    @OneToMany(mappedBy = "game",  fetch = FetchType.EAGER)
    Set<Mod> mods;
}
