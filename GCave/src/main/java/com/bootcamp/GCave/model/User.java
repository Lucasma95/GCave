package com.bootcamp.GCave.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User extends BaseNamedEntity {

   // Set<Transaction> userItems ;

    @OneToMany(mappedBy="user",   fetch = FetchType.EAGER)
    private List<Transaction> items;

}
