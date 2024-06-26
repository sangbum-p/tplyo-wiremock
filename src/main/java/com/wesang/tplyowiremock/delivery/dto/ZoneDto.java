package com.wesang.tplyowiremock.delivery.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record ZoneDto(
        @Schema(description = "요기요 권역 아이디", example = "255") String id,
        @Schema(description = "요기요 권역 이름", example = "서초/강남") String name) {}
