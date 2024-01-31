package me.ricky.aggregate.common.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagingRequest {

	//페이지 번호 (현재)
	@Schema(description = "페이지", example = "1")
	private int page;

	//페이지당 노출 갯수
	@Schema(description = "페이지 크기", allowableValues="range[1, 100]", example = "20")
	private int pageSize;

	//노출 페이징수
	@Schema(hidden = true)
	private int range;

	//페이징 시작
	@Schema(hidden = true)
	private int start;

	public PagingRequest() {
		this.page = 1;
		this.pageSize = 20;
		this.range = 10;
	}
	public int getStart() {
		return this.page - 1;
	}
}
