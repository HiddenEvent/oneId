package me.ricky.aggregate.board.facade.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardDTO {

	private Long id; //게시판 일련번호_PK
	private String title; //제목
	private String content; //내용
	private Boolean delYn; //삭제 여부
	private Boolean useYn; //사용 여부
	private LocalDateTime notiAt; //공지 일시
	private Integer recommendCnt; //추천 개수
	@Getter @Setter
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	public static class Search {
		@Schema(description = "게시판 일련번호", example = "1")
		private Long id;

		@Schema(description = "제목")
		private String title;

		@Schema(description = "내용")
		private String content;

		@Schema(description = "삭제 여부")
		private Boolean delYn;

		@Schema(description = "사용 여부")
		private Boolean useYn;

		@Schema(description = "공지 일시")
		private LocalDateTime notiAt;

		@Schema(description = "추천 개수", example = "1")
		private Integer recommendCnt;

	}
	@Getter @Setter
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	public static class Register {

		@Schema(description = "제목")
		private String title;

		@Schema(description = "내용")
		private String content;

		@Schema(description = "삭제 여부")
		private Boolean delYn;

		@Schema(description = "사용 여부")
		private Boolean useYn;

		@Schema(description = "공지 일시")
		private LocalDateTime notiAt;

		@Schema(description = "추천 개수", example = "1")
		private Integer recommendCnt;

	}
	@Getter @Setter
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	public static class Modify {

		@Schema(description = "제목")
		private String title;

		@Schema(description = "내용")
		private String content;

		@Schema(description = "삭제 여부")
		private Boolean delYn;

		@Schema(description = "사용 여부")
		private Boolean useYn;

		@Schema(description = "공지 일시")
		private LocalDateTime notiAt;

		@Schema(description = "추천 개수", example = "1")
		private Integer recommendCnt;

	}
	@Getter @Setter
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	public static class Response {

		@Schema(description = "게시판 일련번호", example = "1")
		private Long id;

		@Schema(description = "제목")
		private String title;

		@Schema(description = "내용")
		private String content;

		@Schema(description = "삭제 여부")
		private Boolean delYn;

		@Schema(description = "사용 여부")
		private Boolean useYn;

		@Schema(description = "공지 일시")
		private LocalDateTime notiAt;

		@Schema(description = "추천 개수", example = "1")
		private Integer recommendCnt;


	}

}
