package me.ricky.aggregate.user.store.jpo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import me.ricky.aggregate.common.jpo.DomainEntityJpo;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditingDomainJpo extends DomainEntityJpo {
    //@NotAudited
    @CreatedBy  // 최초 생성자
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "createdBy", referencedColumnName = "id", updatable = false, columnDefinition = "varchar(255) comment '생성자 일련번호'")
    //@Audited(targetAuditMode = NOT_AUDITED) // User 테이블까지 이력을 추적하지 않겠다는 설정 필수
    private UserJpo createdBy;

    //@NotAudited
    @LastModifiedBy // 마지막 수정자
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "modifiedBy", referencedColumnName = "id", columnDefinition = "varchar(255) comment '수정자 일련번호'")
    //@Audited(targetAuditMode = NOT_AUDITED) // User 테이블까지 이력을 추적하지 않겠다는 설정 필수
    private UserJpo modifiedBy;
}