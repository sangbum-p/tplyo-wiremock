package com.wesang.tplyowiremock.delivery.dto;

import jakarta.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;

public record RequirementsDto(
        @Schema(description = "가게 요청사항", example = "수저 포크 X / 일회용 수저, 포크가 필요해요.")
                String requirementsToVendor,
        @Schema(description = "라이더 요청사항", example = "문 앞에 놓고, 문자 주세요.") String requirementsToRider,
        @NotNull @Schema(description = "비대면 배달여부: 비대면으로 요청된 배달인지 아닌지를 구분", example = "true")
                Boolean contactless) {}
