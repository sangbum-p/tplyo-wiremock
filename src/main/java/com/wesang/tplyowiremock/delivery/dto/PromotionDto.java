package com.wesang.tplyowiremock.delivery.dto;

import jakarta.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;

public record PromotionDto(
        @NotNull @Schema(description = "프로모션 타입", example = "YOGIYO_PROMOTION_DELAY") String type,
        @NotNull @Schema(description = "프로모션 이름", example = "배차 지연 위험 프로모션") String title,
        @NotNull @Schema(description = "총 프로모션 비용", example = "3000") Integer totalAmount,
        @NotNull @Schema(description = "프로모션 비용 중 요기요 부담 금액", example = "3000") Integer yogiyoAmount) {}
