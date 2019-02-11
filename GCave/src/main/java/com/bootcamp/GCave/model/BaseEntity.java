package com.bootcamp.GCave.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Positive;
import java.time.OffsetDateTime;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    OffsetDateTime creationDate;
    OffsetDateTime editionDate;
    OffsetDateTime deletionDate;

}
