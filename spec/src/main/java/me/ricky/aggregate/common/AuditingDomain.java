package me.ricky.aggregate.common;


import me.ricky.aggregate.user.domain.User;

import java.io.Serializable;

public abstract class AuditingDomain extends Domain implements Serializable {
    private User createdBy;
    private User modifiedBy;

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public User getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(User modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}