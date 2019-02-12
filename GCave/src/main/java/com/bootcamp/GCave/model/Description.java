package com.bootcamp.GCave.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Embeddable
@Getter @Setter @NoArgsConstructor @AllArgsConstructor

public class Description {


    /*@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "items_id", nullable = false)*/
    //Item item;


    String webDescription;
    String mobileDescription;
}
