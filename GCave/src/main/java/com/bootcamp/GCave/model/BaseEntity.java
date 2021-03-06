package com.bootcamp.GCave.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass

public abstract class BaseEntity extends Auditable implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Where(clause = "active=1")
    boolean active;



}
