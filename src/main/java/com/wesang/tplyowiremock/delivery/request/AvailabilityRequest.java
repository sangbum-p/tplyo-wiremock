package com.wesang.tplyowiremock.delivery.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;

import com.wesang.tplyowiremock.delivery.dto.CustomerDto;
import com.wesang.tplyowiremock.delivery.dto.VendorDto;
import com.wesang.tplyowiremock.delivery.enums.DeliveryServingType;
import com.wesang.tplyowiremock.delivery.enums.DispatchType;

public record AvailabilityRequest(
        @Valid @NotNull @Schema(description = "요기요 상점(출발지) 정보") VendorDto vendor,
        @Valid @NotNull @Schema(description = "고객(도착지) 정보") CustomerDto customer,
        @NotNull @Schema(description = "배달 타입\n- STACKABLE: 실속배달\n- DIRECT: 한집배달\n- ECONOMY: 알뜰 배달")
                DeliveryServingType deliveryServingType,
        @NotNull
                @Schema(description = "배차 타입\n- SEND_TO_VENDOR_FIRST: 가게 선전달\n- DISPATCH_FIRST: 라이더 선배차")
                DispatchType dispatchType,
        @Schema(description = "주류 포함 여부", example = "false") boolean hasLiquor) {}
