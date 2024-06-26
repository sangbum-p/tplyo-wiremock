package com.wesang.tplyowiremock.delivery.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;

public record VendorDto(
        @Schema(description = "요기요 상점(출발지) 아이디", example = "1001001") String id,
        @NotNull @Schema(description = "요기요 상점(출발지) 명", example = "요기요 가게") String name,
        @Schema(description = "요기요 상점(출발지) 핸드폰 번호", example = "02-0000-0000") String phone,
        @Valid @Schema(description = "요기요 상점(출발지) 주소 정보") AddressDto address) {}
