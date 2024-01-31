package me.ricky.aggregate.common.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class DataHandleRequest {
    @Getter
	@Setter
	public static class EnumSearch {
		@Schema(description = "열거형 이름들", required = true, type = "array", example = "[\"code1\", \"code2\"]", implementation = String.class)
        private List<String> names;
	}
}
