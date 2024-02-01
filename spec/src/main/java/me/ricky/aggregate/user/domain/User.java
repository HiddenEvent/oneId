package me.ricky.aggregate.user.domain;


import lombok.*;
import me.ricky.aggregate.common.Domain;
import me.ricky.aggregate.user.domain.enums.RoleType;
import me.ricky.aggregate.user.facade.dto.UserRequest;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User extends Domain {
    private String name; //이름
    private String address; //주소
    private String email; //이메일
    private RoleType roleType; //역할 유형
    private String sub; //통합 ID

    public static User genRegisterDomain(UserRequest.Register reqDto) {
        User domain = new User();
        BeanUtils.copyProperties(reqDto, domain);
        return domain;
    }
}
