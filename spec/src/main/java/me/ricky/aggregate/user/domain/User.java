package me.ricky.aggregate.user.domain;


import lombok.*;
import me.ricky.aggregate.common.DomainEntity;
import me.ricky.aggregate.user.domain.enums.RoleType;
import me.ricky.aggregate.user.facade.dto.UserRequest;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User extends DomainEntity {
    private String password; //패스워드
    private String name; //이름
    private String address; //주소
    private String email; //이메일
    private String phone; //연락처
    private RoleType roleType; //역할 유형
    private String checkpointId; //통합 ID

    public static User genRegisterDomain(UserRequest.Register reqDto, String encodePassword) {
        User domain = new User();
        BeanUtils.copyProperties(reqDto, domain);
        domain.password = encodePassword;
        return domain;
    }
}
