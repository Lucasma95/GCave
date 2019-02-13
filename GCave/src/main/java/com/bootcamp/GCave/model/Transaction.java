package com.bootcamp.GCave.model;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="transactions")
@IdClass(TransactionAssociationId.class)
public class Transaction {



    @Id
    Long id;

    private long userId;

    private long itemId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "users_id")//, referencedColumnName="id"
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "items_id")//,referencedColumnName="id"
    private Item item;




}
