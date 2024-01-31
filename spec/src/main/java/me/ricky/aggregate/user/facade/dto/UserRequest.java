package me.ricky.aggregate.user.facade.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import me.ricky.aggregate.common.dto.SearchRequest;
import me.ricky.aggregate.user.domain.enums.RoleType;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {

	private String id; //회원 일련번호_PK
	private String password; //패스워드
	private String name; //이름
	private String address; //주소
	private String email; //이메일
	private String phone; //연락처
	private RoleType roleType; //역할 유형
	@Getter
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	public static class Search extends SearchRequest {
		@Schema(description = "회원 ID")
		private String id;

		@Schema(description = "패스워드")
		private String password;

		@Schema(description = "이름")
		private String name;

		@Schema(description = "주소")
		private String address;

		@Schema(description = "이메일")
		private String email;

		@Schema(description = "연락처")
		private String phone;

		@Schema(description = "역할 유형")
		private RoleType roleType;
	}
	@Getter @Setter
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	public static class Login {
		@Schema(description = "회원 id")
		private String id;

		@Schema(description = "패스워드")
		private String password;

		@Schema(description = "이름")
		private String name;

		@Schema(description = "주소")
		private String address;

		@Schema(description = "이메일")
		private String email;

		@Schema(description = "연락처")
		private String phone;

		@Schema(description = "역할 유형")
		private RoleType roleType;
	}

	@Getter @Setter
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	public static class Register {

		@NotBlank
		@Size(min = 4, message = "Password는 4자리 이상 입력해주세요")
		@Schema(description = "패스워드", example = "1234")
		private String password;

		@Schema(description = "이름")
		private String name;

		@Schema(description = "주소")
		private String address;

		@Email(message = "Email 형식을 맞춰서 입력해주세요")
		@Schema(description = "이메일", example = "a@aa.com")
		private String email;

		@NotBlank
		@Schema(description = "연락처", example = "01000000000")
		private String phone;

		@Schema(description = "역할 유형")
		private RoleType roleType;
	}
	@Getter @Setter
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	public static class Modify {

		@Schema(description = "패스워드")
		private String password;

		@Schema(description = "이름")
		private String name;

		@Schema(description = "주소")
		private String address;

		@Schema(description = "이메일")
		private String email;

		@Schema(description = "연락처")
		private String phone;

		@Schema(description = "역할 유형")
		private RoleType roleType;
	}
}
