package com.bootcamp.GCave.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="items")
public class Item extends  BaseNamedEntity {

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "itemss")
    private Set<User> userss = new HashSet<>();


    //@JsonIgnore
    @OneToOne(fetch = FetchType.EAGER, cascade =  CascadeType.ALL, mappedBy = "item")
    Description description;

}
