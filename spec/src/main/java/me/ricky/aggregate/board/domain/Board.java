package me.ricky.aggregate.board.domain;

import me.ricky.aggregate.common.AuditingDomain;

import java.time.LocalDateTime;

public class Board extends AuditingDomain {
    private String title;
    private String content;
    private Boolean delYn;
    private Boolean useYn;
    private LocalDateTime notiAt;
    private Integer recommendCnt;
}
