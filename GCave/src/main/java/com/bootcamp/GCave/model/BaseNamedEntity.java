package com.bootcamp.GCave.model;


import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseNamedEntity extends BaseEntity {

    String name;
}
