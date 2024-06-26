package com.wesang.tplyowiremock.delivery.request;

import jakarta.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;

public record VendorAcceptanceRequest(
        @NotNull @Schema(description = "배달대행사 배달 번호", example = "18051851296124")
                String agencyDeliveryId,
        @NotNull @Schema(description = "배달 요청 번호", example = "302547092140407810")
                Integer deliveryRequestId,
        @NotNull @Schema(description = "픽업요청 시간(단위: 초). 주문 후 조리완료 및 주문 준비 완료에 걸리는 시간", example = "1800")
                Integer requestPickupSeconds) {}
