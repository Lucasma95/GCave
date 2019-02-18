package com.bootcamp.GCave.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Table(name="items")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Where(clause = "active=1")
public abstract class Item extends  BaseNamedEntity {



    @JsonIgnore
    @ManyToMany(mappedBy = "items")
    private Set<User> users = new HashSet<>();





    @Embedded
    Description description;

}
