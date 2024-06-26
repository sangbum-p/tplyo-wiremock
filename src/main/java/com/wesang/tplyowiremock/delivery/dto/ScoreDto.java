package com.wesang.tplyowiremock.delivery.dto;

import jakarta.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;

public record ScoreDto(
        @NotNull @Schema(description = "스코어 타입", example = "PRIORITY") String type,
        @NotNull @Schema(description = "스코어 명", example = "배달 우선 순위") String title,
        @NotNull @Schema(description = "스코어 값: [0, 1] 사이의 float으로 전달", example = "0.8") Float score,
        @NotNull @Schema(description = "등급", example = "very_high") String grade,
        @Schema(description = "등급 이름", example = "매우 높음") String gradeName) {}
