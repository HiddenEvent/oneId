package me.ricky.aggregate.common.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageQdo {
	@Schema(description = "기준", example = "0")
	private int offset;
	@Schema(description = "페이지당 조회 건수", example = "10")
	private int limit;
}
