package com.wesang.tplyowiremock.delivery.request;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;

import com.wesang.tplyowiremock.delivery.dto.CustomerDto;
import com.wesang.tplyowiremock.delivery.dto.ItemDetailDto;
import com.wesang.tplyowiremock.delivery.dto.PaymentsDto;
import com.wesang.tplyowiremock.delivery.dto.PromotionDto;
import com.wesang.tplyowiremock.delivery.dto.RequirementsDto;
import com.wesang.tplyowiremock.delivery.dto.ScoreDto;
import com.wesang.tplyowiremock.delivery.dto.VendorDto;
import com.wesang.tplyowiremock.delivery.dto.ZoneDto;
import com.wesang.tplyowiremock.delivery.enums.DeliveryServingType;
import com.wesang.tplyowiremock.delivery.enums.DispatchType;

public record SubmitRequest(
        @NotNull @Schema(description = "배달 요청 번호", example = "302547092140407810")
                Long deliveryRequestId,
        @Schema(description = "요기요 주문 번호", example = "F240101130212") String orderNumber,
        @NotNull @Schema(description = "배달 타입\n- STACKABLE: 실속배달\n- DIRECT: 한집배달\n- ECONOMY: 알뜰 배달")
                DeliveryServingType deliveryServingType,
        @NotNull
                @Schema(description = "배차 타입\n- SEND_TO_VENDOR_FIRST: 가게 선전달\n- DISPATCH_FIRST: 라이더 선배차")
                DispatchType dispatchType,
        @NotNull @Schema(description = "픽업요청 시간(단위: 초). 주문 후 조리완료 및 주문 준비 완료에 걸리는 시간", example = "1800")
                Integer requestPickupSeconds,
        @Schema(description = "가게별 주문을 간단히 식별할 수 있는 코드", example = "101") String shortCode,
        @Schema(description = "우선순위 배달 여부", example = "true") Boolean isPriorityDelivery,
        @Schema(description = "지점 아이디", example = "hub-001") String hubId,
        @NotNull @Schema(description = "주류 포함 여부", example = "false") boolean hasLiquor,
        @Valid @NotNull @Schema(description = "요기요 상점(출발지) 정보") VendorDto vendor,
        @Valid @NotNull @Schema(description = "고객(도착지) 정보") CustomerDto customer,
        @Valid @NotNull @Schema(description = "요청사항 정보") RequirementsDto requirement,
        @Valid @NotNull @Schema(description = "할인 정보") PaymentsDto payments,
        @Valid
                @NotNull
                @Schema(
                        description =
                                "상품의 상세 내용\n옵션 구분\n1. 필수옵션: 상품명에 포함하여 전달 (ex. XX치킨 -L)\n2. 선택옵션: 옵션 필드에 넣어 전달")
                List<ItemDetailDto> itemDetails,
        @Valid @Schema(description = "요기요 권역 정보") ZoneDto zone,
        @Valid @Schema(description = "스코어 정보") List<ScoreDto> scores,
        @Valid @Schema(description = "프로모션 정보") List<PromotionDto> promotions) {}
