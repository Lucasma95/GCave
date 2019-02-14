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


   @ManyToMany(cascade = CascadeType.ALL)//
   @JoinTable(name = "UserItem",
           joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
           inverseJoinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id"))
   private Set<Item> items;

}
