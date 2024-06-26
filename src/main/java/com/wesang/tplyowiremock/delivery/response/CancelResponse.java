package com.wesang.tplyowiremock.delivery.response;

import com.wesang.tplyowiremock.delivery.enums.DeliveryState;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public record CancelResponse(
    @NotNull @Schema(description = "이전 배달 상태\n" + DELIVERY_STATE_DESCRIPTION, example = "WAITING_FOR_TRANSPORT") DeliveryState beforeDeliveryState,
    @NotNull @Schema(description = "현재 배달 상태\n" + DELIVERY_STATE_DESCRIPTION, example = "CANCELLED") DeliveryState deliveryState
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
