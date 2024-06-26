package com.wesang.tplyowiremock.delivery.dto;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;

public record DeliveryFeeDto(
        @NotNull @Schema(description = "배달비: 출발 지점과 도착 지점 간 거리로 측정되는 요금", example = "3000")
                Integer baseFee,
        @NotNull @Schema(description = "할증 배달비: 심야, 우천 등의 사유로 추가되는 배달비", example = "500")
                Integer extraFee,
        @NotNull @Schema(description = "배달비 합계 금액: 배달비 + 할증 배달비", example = "3500") Integer sumTotal,
        @NotNull @Schema(description = "배달거리(m)", example = "1632.1") Float distance,
        @NotNull @Schema(description = "거리 할증비", example = "3000") Integer distanceFee,
        @NotNull @Schema(description = "기본 배달비", example = "3000") Integer minimumFee,
        @NotNull @Schema(description = "VAT 포함 여부", example = "true") Boolean hasVat,
        @NotNull @Schema(description = "VAT 가격", example = "120") Integer vatFee,
        @Valid @Schema(description = "할증 상세 내용. 하나의 할증 타입에 여러개의 할증이 설정 가능합니다")
                List<ExtraFeeDto> extraFeeDetails) {}
