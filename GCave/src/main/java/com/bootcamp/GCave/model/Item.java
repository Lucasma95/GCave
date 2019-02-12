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
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Table(name="items")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Item extends  BaseNamedEntity {



    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "itemss")
    private Set<User> userss = new HashSet<>();




    /*@AttributeOverrides(value = {
            @AttributeOverride(name = "id", column = @Column(name = "id_description")),

    })*/
    @Embedded
    Description description;

}
