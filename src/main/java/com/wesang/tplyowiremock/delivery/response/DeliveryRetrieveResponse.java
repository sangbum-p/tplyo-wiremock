package com.wesang.tplyowiremock.delivery.response;

import com.wesang.tplyowiremock.delivery.dto.CustomerDto;
import com.wesang.tplyowiremock.delivery.dto.DeliveryFeeDto;
import com.wesang.tplyowiremock.delivery.dto.ItemDetailDto;
import com.wesang.tplyowiremock.delivery.dto.RequirementsDto;
import com.wesang.tplyowiremock.delivery.dto.VendorDto;
import com.wesang.tplyowiremock.delivery.enums.DeliveryState;
import com.wesang.tplyowiremock.delivery.enums.PaymentType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DeliveryRetrieveResponse(
        @NotNull @Schema(description = "현재 배달 상태\n" + DELIVERY_STATE_DESCRIPTION, example = "DELIVERED") DeliveryState deliveryState,
        @Schema(description = "배달대행사 배달 번호", example = "18051851296124") String agencyDeliveryId,
        @Valid @Schema(description = "배달비 정보") DeliveryFeeDto deliveryFee,
        @Valid @Schema(description = "요기요 상점(출발지) 정보") VendorDto vendor,
        @Valid @Schema(description = "고객(도착지) 정보") CustomerDto customer,
        @Valid @Schema(description = "요청사항 정보") RequirementsDto requirement,
        @Schema(
                description =
                        "결제 수단\n-PREPAID: 선불/온라인으로 결제가 끝난 주문정보\n-CREDIT_CARD: 기사앱에서 카드 결제\n- CASH: 기사가 현금 수취",
                example = "PREPAID")
        PaymentType paymentMethod,
        @Schema(description = "결제필요금액 변경 후 쿠폰/할인 적용 후 고객이 결제해야하는 금액", example = "0")
        Integer paymentRequiredAmounts,
        @Schema(description = "픽업요청 시간(단위: 초). 주문 후 조리완료 및 주문 준비 완료에 걸리는 시간", example = "1800")
        Integer requestPickupSeconds,
        @Schema(description = "요기요 주문 번호", example = "F240101130212") String orderNumber,
        @Valid
        @Schema(
                description =
                        "상품의 상세 내용\n옵션 구분\n1. 필수옵션: 상품명에 포함하여 전달 (ex. XX치킨 -L)\n2. 선택옵션: 옵션 필드에 넣어 전달")
        List<ItemDetailDto> itemDetails,
        @Schema(description = "가게별 주문을 간단히 식별할 수 있는 코드", example = "101") String shortCode,
        @Schema(description = "주류 포함 여부", example = "false") boolean hasLiquor
) {
    private static final String DELIVERY_STATE_DESCRIPTION = """
                        배달 상태
                        \n- NOT_FOUND: 배달대행사에 접수되지 않은 배달
                        \n- WAITING_FOR_TRANSPORT : 접수가 완료되어 기사배정을 기다리는 상태
                        \n- ASSIGNED_TO_TRANSPORT : 기사배정이 완료되어 픽업까지 하러 가는 상태
                        \n- PICKED_UP : 픽업 완료하여 배달까지 진행하고 있는 상태
                        \n- DELIVERED : 배달 완료
                        \n- CANCELLED : 배달 취소
            """;
}
