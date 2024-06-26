package com.wesang.tplyowiremock.delivery.dto;

import java.util.List;

import jakarta.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;

import com.wesang.tplyowiremock.delivery.enums.PaymentType;

public record PaymentsDto(
        @NotNull @Schema(description = "고객 총 결제 금액", example = "150000") Integer totalPrice,
        @NotNull
                @Schema(
                        description =
                                "결제 수단\n-PREPAID: 선불/온라인으로 결제가 끝난 주문정보\n-CREDIT_CARD: 기사앱에서 카드 결제\n- CASH: 기사가 현금 수취",
                        example = "PREPAID")
                PaymentType paymentMethod,
        @NotNull @Schema(description = "결제필요금액 변경 후 쿠폰/할인 적용 후 고객이 결제해야하는 금액", example = "0")
                Integer paymentRequiredAmounts,
        @Schema(
                        description = "전체 결제 금액 중 고객이 지불한 배달비\n- 고객이 지불한 배달비가 있는 경우 item_details에 포함되어 있습니다.",
                        example = "3000")
                Integer paidDeliveryFee,
        @Schema(
                        description =
                                "전체 결제 금액 중 고객이 지불한 일회용컵 보증금의 합계\n- 보증금은 300원의 배수입니다. (예: 0원, 300원, 600원)\n- 고객이 지불한 일회용컵 보증금이 있는 경우 item_details-option_details에 포함되어 있습니다.",
                        example = "0")
                Integer disposableCupDepositAmount,
        @Schema(description = "할인 정보") List<Discounts> discounts) {

    public record Discounts(
            @Schema(description = "할인 항목명", example = "할인") String title,
            @Schema(description = "할인 적용 금액", example = "500") Integer amount) {}
}
