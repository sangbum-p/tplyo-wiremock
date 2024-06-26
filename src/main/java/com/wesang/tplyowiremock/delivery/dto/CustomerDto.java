package com.wesang.tplyowiremock.delivery.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;

public record CustomerDto(
        @NotNull @Schema(description = "고객(도착지) 핸드폰 번호") String phone,
        @Valid @Schema(description = "고객(도착지) 주소 정보") AddressDto address) {}
