package me.ricky.aggregate.user.store.jpo;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.ricky.aggregate.common.jpo.DomainEntityJpo;
import me.ricky.aggregate.user.domain.User;
import me.ricky.aggregate.user.domain.enums.RoleType;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@Table(name = "users")
@Comment("회원")
public class UserJpo extends DomainEntityJpo implements Serializable {

    @Comment("주소")
    private String address;

    @Comment("역할 유형")
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Comment("통합 ID")
    private String sub;

    public User toDomain() {
        User doamin = new User();
        BeanUtils.copyProperties(this, doamin);
        return doamin;
    }

    public static UserJpo domainToJpo(User domain) {
        UserJpo userJpo = new UserJpo();
        BeanUtils.copyProperties(domain, userJpo);
        return userJpo;
    }

    public void modify(User domain) {
        BeanUtils.copyProperties(domain, this);
    }

    public static UserJpo makeById(String id) {
        UserJpo userJpo = new UserJpo();
        userJpo.setId(id);
        return userJpo;
    }
}
