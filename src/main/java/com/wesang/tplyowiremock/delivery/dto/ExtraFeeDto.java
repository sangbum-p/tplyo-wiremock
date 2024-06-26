package com.wesang.tplyowiremock.delivery.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import com.wesang.tplyowiremock.delivery.enums.FeeType;

public record ExtraFeeDto(
        @Schema(
                        description =
                                "- WEEKLY_HOURS: 요일/시간 할증\n- REGIONS: 지역 할증\n- UNCONDITIONAL: 요일/시간 혹은 지역 제한이 없는 할증\n- WEATHER: 기상 할증\n- POLYGON: 지역 폴리곤\n- RELOCATE_DEST: 재이동 배달비",
                        example = "REGIONS")
                FeeType type,
        @Schema(description = "할증 금액", example = "3500") Integer amount,
        @Schema(description = "할증 제목", example = "삼성동 할증") String title) {}
