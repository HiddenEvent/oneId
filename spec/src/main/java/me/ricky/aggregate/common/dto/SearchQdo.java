package me.ricky.aggregate.common.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 시스템에서 중복되는 param 정의
 */
@Getter
@Setter
public class SearchQdo extends PageQdo {
    @Schema(description = "검색어")
    private String searchText;
    @Schema(description = "검색 시작 일자 ex) yyyy-MM-dd")
    private String startDate;
    @Schema(description = "검색 종료 일자 ex) yyyy-MM-dd")
    private String endDate;
}
