package com.wesang.tplyowiremock.delivery.dto;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;

public record ItemDetailDto(
        @NotNull
                @Schema(description = "상품 타입\n- ITEM: 일반 상품\n- DELIVERY_FEE: 고객이 지불한 배달비", example = "ITEM")
                String type,
        @NotNull @Schema(description = "상품 이름", example = "짬뽕") String name,
        @NotNull @Schema(description = "상품 수량", example = "5") Integer quantity,
        @NotNull @Schema(description = "상품 단가", example = "30000") Integer unitPrice,
        @NotNull @Schema(description = "삼품과 옵션을 모두 포함한 총 가격", example = "150000") Integer totalPrice,
        @Schema(description = "상품 총 가격", example = "150000") Integer itemTotalPrice,
        @Schema(description = "옵션 총 가격", example = "0") Integer optionsTotalPrice,
        @NotNull @Valid @Schema(description = "상품 옵션의 상세 내용") List<OptionDetail> optionDetails) {

    public record OptionDetail(
            @NotNull @Schema(description = "상품 옵션 이름", example = "곱배기") String name,
            @NotNull @Schema(description = "상품 옵션 수량", example = "1") String quantity,
            @NotNull @Schema(description = "상품 옵션 단가", example = "0") Integer unitPrice,
            @NotNull @Schema(description = "상품 옵션 총 가격", example = "0") Integer totalPrice) {}
}
