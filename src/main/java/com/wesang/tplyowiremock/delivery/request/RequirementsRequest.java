package com.wesang.tplyowiremock.delivery.request;

import jakarta.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;

public record RequirementsRequest(
        @NotNull @Schema(description = "배달대행사 배달 번호", example = "18051851296124")
                String agencyDeliveryId,
        @NotNull @Schema(description = "배달 요청 번호", example = "302547092140407810")
                Integer deliveryRequestId,
        @Schema(description = "가게 요청사항", example = "수저 포크 X / 일회용 수저, 포크가 필요해요.")
                String requirementsToVendor,
        @Schema(description = "라이더 요청사항", example = "문 앞에 놓고, 문자 주세요.") String requirementsToRider) {}
