package com.bootcamp.GCave.model;

import java.io.Serializable;

public class TransactionAssociationId implements Serializable {

    private long userId;

    private long itemId;


    public int hashCode() {
        return (int)(userId + itemId);
    }

    public boolean equals(Object object) {
        if (object instanceof TransactionAssociationId) {
            TransactionAssociationId otherId = (TransactionAssociationId) object;
            return (otherId.userId == this.userId) && (otherId.itemId == this.itemId);
        }
        return false;
    }


}
