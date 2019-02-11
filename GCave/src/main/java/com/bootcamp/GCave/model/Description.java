package com.bootcamp.GCave.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Table(name="descriptions")
public class Description extends BaseEntity{


    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "items_id", nullable = false)
    Item item;


    String webDescription;
    String mobileDescription;
}
