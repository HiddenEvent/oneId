package me.ricky.aggregate.board.store.jpo;


import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import me.ricky.aggregate.board.domain.Board;
import me.ricky.aggregate.board.facade.dto.BoardDTO;
import me.ricky.aggregate.common.util.BooleanToYNConverter;
import me.ricky.aggregate.user.store.jpo.AuditingDomainJpo;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(access = AccessLevel.PROTECTED)
@Entity
@Getter
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@Table(name = "boards")
@Comment("게시판")
public class BoardJpo extends AuditingDomainJpo implements Serializable {

    @Column(columnDefinition = "varchar(150) comment '제목'")
    private String title;

    @Column(columnDefinition = "varchar(150) comment '내용'")
    private String content;

    @Column(columnDefinition = "char(1) comment '삭제 여부'")
    @Convert(converter = BooleanToYNConverter.class)
    private Boolean delYn;

    @Column(columnDefinition = "char(1) comment '사용 여부'")
    @Convert(converter = BooleanToYNConverter.class)
    private Boolean useYn;

    @Column(columnDefinition = "datetime comment '공지 일시'")
    private LocalDateTime notiAt;

    @Column(columnDefinition = "int(11) comment '추천 개수'")
    private Integer recommendCnt;
	public Board toDomain() {
		Board board = new Board();
		BeanUtils.copyProperties(this, board);
		return board;
	}

	public static BoardJpo domainToJpo(Board domain) {
		BoardJpo boardJpo = new BoardJpo();
		boardJpo.title = domain.getTitle();
		boardJpo.content = domain.getContent();
		boardJpo.delYn = domain.getDelYn();
		boardJpo.useYn = domain.getUseYn();
		boardJpo.notiAt = domain.getNotiAt();
		boardJpo.recommendCnt = domain.getRecommendCnt();
		return boardJpo;
	}

	public void modify(BoardDTO.Modify reqDto) {
		this.title = reqDto.getTitle();
		this.content = reqDto.getContent();
		this.delYn = reqDto.getDelYn();
		this.useYn = reqDto.getUseYn();
		this.notiAt = reqDto.getNotiAt();
		this.recommendCnt = reqDto.getRecommendCnt();
	}
	public static BoardJpo makeById(String id) {
		BoardJpo boardJpo = new BoardJpo();
		boardJpo.id = id;
		return boardJpo;
	}
}
