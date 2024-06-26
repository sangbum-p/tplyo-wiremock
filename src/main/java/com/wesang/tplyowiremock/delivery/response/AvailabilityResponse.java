package com.wesang.tplyowiremock.delivery.response;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;

import com.wesang.tplyowiremock.delivery.dto.DeliveryFeeDto;

public record AvailabilityResponse(
        @Valid @NotNull @Schema(description = "배달비 정보") DeliveryFeeDto deliveryFee,
        @Schema(description = "지점 설정 배달지연 시간: 지점에서 설정한 픽업지연 시간(단위: 분)", example = "10")
                Integer pickUpDelayMinutes,
        @Schema(description = "픽업 요청 가능한 시간(단위: 분)", example = "20") Integer minPickupOffsetMinutes,
        @Schema(
                        description = "배차 반환 가능 여부 (default: false) 요기요에 배차를 반환할 수있는 주문인지 아닌지를 구분",
                        example = "true")
                boolean reclaimable,
        @Schema(description = "배차 제한 시간 (단위: 초) 배차를 반환할 수 잇는 주문에 대해서만 배차 제한 시간이 적용됩니다", example = "120")
                Integer maxReclaimableSeconds,
        @Schema(description = "배달 가능한 지점 목록") List<String> hubIds) {}
