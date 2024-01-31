package me.ricky.aggregate.common.jpo;


import jakarta.persistence.*;
import me.ricky.aggregate.common.Domain;
import me.ricky.aggregate.common.json.JsonSerializable;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Objects;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class DomainEntityJpo implements JsonSerializable {
    @Id
    protected String id;
    @Version
    protected long entityVersion;
    @CreatedDate // 최초 생성한 날
    @Column(updatable = false, columnDefinition = "DATETIME(6) comment '생성 일시'")
    private LocalDateTime createdAt;
    @LastModifiedDate  // 마지막 수정한 날
    @Column(columnDefinition = "DATETIME(6) comment '수정 일시'")
    private LocalDateTime modifiedAt;

    protected DomainEntityJpo(String id) {
        this.id = id;
        this.entityVersion = 0L;

    }

    protected DomainEntityJpo(Domain domain) {
        this.id = domain.getId();
        this.entityVersion = domain.getEntityVersion();
    }

    public boolean equals(Object target) {
        if (this == target) {
            return true;
        } else if (target != null && this.getClass() == target.getClass()) {
            DomainEntityJpo entity = (DomainEntityJpo) target;
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

    public DomainEntityJpo() {
    }
}
