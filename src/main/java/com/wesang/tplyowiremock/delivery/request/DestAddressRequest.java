package com.wesang.tplyowiremock.delivery.request;

import jakarta.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;

import com.wesang.tplyowiremock.delivery.dto.AddressDto;

public record DestAddressRequest(
        @NotNull @Schema(description = "배달대행사 배달 번호", example = "18051851296124")
                String agencyDeliveryId,
        @NotNull @Schema(description = "배달 요청 번호", example = "302547092140407810")
                Integer deliveryRequestId,
        @NotNull @Schema(description = "수정 도착지 정보") AddressDto address) {}
