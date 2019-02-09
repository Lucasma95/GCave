package com.bootcamp.GCave.model;

import java.time.OffsetDateTime;

public abstract class BaseEntity {

    Long id;
    OffsetDateTime creationDate;
    OffsetDateTime editionDate;
    OffsetDateTime deletionDate;

}
