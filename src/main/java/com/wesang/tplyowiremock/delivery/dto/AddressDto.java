package com.wesang.tplyowiremock.delivery.dto;

import jakarta.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;

public record AddressDto(
        @NotNull
                @Schema(
                        description = "지번 기본주소, 시/도 + 시/군/구 + 읍/면/동 (+ 리) + 번지",
                        example = "서울시 서초구 서초동 서초대로 38길 마제스타시티 1층")
                String landAddress,
        @NotNull @Schema(description = "지번 상세주소", example = "상세주소") String landAddressDetail,
        @NotNull
                @Schema(
                        description = "도로명 기본주소, 시/도 + 시/군/구 (+ 리) + 도로명 + 건물번호",
                        example = "서울특별시 서초구 서초대로38길 12 마제스타 시티 1층")
                String roadAddress,
        @NotNull @Schema(description = "도로명 상세주소 (건물명, 아파트 동/호)", example = "상세주소")
                String roadAddressDetail,
        @Schema(description = "라이더용 위치설명", example = "간판명: YOGIYO") String description,
        @NotNull @Schema(description = "위도", example = "37.4902425260905") String latitude,
        @NotNull @Schema(description = "경도", example = "127.005612116111") String longitude) {}
