package me.ricky.aggregate.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import me.ricky.aggregate.common.json.JsonSerializable;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public abstract class DomainEntity implements JsonSerializable, Serializable {
    private static final long serialVersionUID = 805201038388117274L;
    private String id;
    @JsonIgnore
    private long entityVersion;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime createdAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime modifiedAt;

    protected DomainEntity() {
        this.id = UUID.randomUUID().toString();
    }

    protected DomainEntity(String id) {
        this.id = id;
    }

    protected DomainEntity(DomainEntity domainEntity) {
        this.id = domainEntity.getId();
        this.entityVersion = domainEntity.getEntityVersion();
    }

    public boolean equals(Object target) {
        if (this == target) {
            return true;
        } else if (target != null && this.getClass() == target.getClass()) {
            DomainEntity entity = (DomainEntity)target;
            return Objects.equals(this.id, entity.id);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.id});
    }

    public String toString() {
        return this.toJson();
    }

    public String getId() {
        return this.id;
    }

    public long getEntityVersion() {
        return this.entityVersion;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEntityVersion(long entityVersion) {
        this.entityVersion = entityVersion;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}