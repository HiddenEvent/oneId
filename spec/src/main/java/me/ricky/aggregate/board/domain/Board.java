package me.ricky.aggregate.board.domain;

import lombok.*;
import me.ricky.aggregate.board.facade.dto.BoardDTO;
import me.ricky.aggregate.common.AuditingDomain;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Board extends AuditingDomain {
    private String title;
    private String content;
    private Boolean delYn;
    private Boolean useYn;
    private LocalDateTime notiAt;
    private Integer recommendCnt;
    public static Board register(BoardDTO.Register req) {
        Board domain = new Board();
        BeanUtils.copyProperties(req, domain);
        return domain;
    }
}
