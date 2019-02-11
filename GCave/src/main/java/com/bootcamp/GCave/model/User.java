package com.bootcamp.GCave.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseNamedEntity {

   // Set<UserItem> userItems ;

    @ManyToMany(fetch = FetchType.EAGER,
                cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
                })
    @JoinTable(name = "UserItem",
            joinColumns = { @JoinColumn(name = "users_id") },
            inverseJoinColumns = { @JoinColumn(name = "items_id") })
    private Set<Item> itemss = new HashSet<>();
}
