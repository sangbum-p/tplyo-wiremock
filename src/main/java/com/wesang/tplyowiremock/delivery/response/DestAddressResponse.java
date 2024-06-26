package com.wesang.tplyowiremock.delivery.response;

import jakarta.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;

import com.wesang.tplyowiremock.delivery.dto.AddressDto;
import com.wesang.tplyowiremock.delivery.dto.DeliveryFeeDto;

public record DestAddressResponse(
        @NotNull @Schema(description = "수정된 도착지 정보") AddressDto address,
        @NotNull @Schema(description = "변경된 배달비 정보") DeliveryFeeDto deliveryFee) {}
