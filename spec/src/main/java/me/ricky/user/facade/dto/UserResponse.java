package me.ricky.user.facade.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.ricky.user.domain.enums.RoleType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private Long seq; //회원 일련번호_PK
    private String password; //패스워드
    private String name; //이름
    private String address; //주소
    private String email; //이메일
    private String phone; //연락처
    private RoleType roleType; //역할 유형

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Search {
        @Schema(description = "회원 일련번호")
        private Long seq; //회원 일련번호_PK
        private String password; //패스워드
        private String name; //이름
        private String address; //주소
        private String email; //이메일
        private String phone; //연락처
        private RoleType roleType; //역할 유형
    }
}
