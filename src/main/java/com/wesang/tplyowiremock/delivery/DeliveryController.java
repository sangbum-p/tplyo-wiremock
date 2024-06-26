package com.wesang.tplyowiremock.delivery;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.wesang.tplyowiremock.delivery.request.AvailabilityRequest;
import com.wesang.tplyowiremock.delivery.request.CancelRequest;
import com.wesang.tplyowiremock.delivery.request.DestAddressRequest;
import com.wesang.tplyowiremock.delivery.request.FoodReadyRequest;
import com.wesang.tplyowiremock.delivery.request.RequirementsRequest;
import com.wesang.tplyowiremock.delivery.request.SubmitRequest;
import com.wesang.tplyowiremock.delivery.request.VendorAcceptanceRequest;
import com.wesang.tplyowiremock.delivery.response.AvailabilityResponse;
import com.wesang.tplyowiremock.delivery.response.CancelResponse;
import com.wesang.tplyowiremock.delivery.response.DeliveryRetrieveResponse;
import com.wesang.tplyowiremock.delivery.response.DestAddressResponse;
import com.wesang.tplyowiremock.delivery.response.ResponseBase;

@Tag(name = "배달 API", description = "배달 대행사의 주소로 배송 서비스에 대한 요청을 실시간으로 전달합니다.")
@RestController
public class DeliveryController {
    private static final String PREFIX = "/yogiyo/api/v2/delivery";
    private static final String AVAILABILITY_PATH = "/availability";
    private static final String SUBMIT_PATH = "/submit";
    private static final String DEST_ADDRESS_PATH = "/dest-address";
    private static final String REQUIREMENTS_PATH = "/requirements";
    private static final String FOOD_READY_PATH = "/food-ready";
    private static final String VENDOR_ACCEPT_PATH = "/vendor-acceptance";
    private static final String CANCEL_PATH = "/cancel";

    @PostMapping(value = PREFIX + AVAILABILITY_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "배달 가능 여부", description = "배달 가능 여부")
    @ApiResponse(responseCode = "200", description = "200 OK")
    public ResponseEntity<ResponseBase<AvailabilityResponse>> availability(
            @RequestBody AvailabilityRequest request) {
        return null;
    }

    @PostMapping(value = PREFIX + SUBMIT_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "배달 요청", description = "배달 요청")
    @ApiResponse(responseCode = "200", description = "200 OK")
    public ResponseEntity<ResponseBase<Void>> submit(@RequestBody SubmitRequest request) {
        return null;
    }

    @PatchMapping(value = PREFIX + DEST_ADDRESS_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "도착지 주소 수정", description = "도착지 주소 수정")
    @ApiResponse(responseCode = "200", description = "200 OK")
    public ResponseEntity<ResponseBase<DestAddressResponse>> destAddress(
            @RequestBody DestAddressRequest request) {
        return null;
    }

    @PostMapping(value = PREFIX + REQUIREMENTS_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "요청사항 수정", description = "요청사항 수정")
    @ApiResponse(responseCode = "200", description = "200 OK")
    public ResponseEntity<ResponseBase<Void>> requirements(@RequestBody RequirementsRequest request) {
        return null;
    }

    @PostMapping(value = PREFIX + FOOD_READY_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "조리 완료", description = "조리 완료")
    @ApiResponse(responseCode = "200", description = "200 OK")
    public ResponseEntity<ResponseBase<Void>> foodReady(@RequestBody FoodReadyRequest request) {
        return null;
    }

    @PostMapping(value = PREFIX + VENDOR_ACCEPT_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "가게 수락", description = "가게 수락")
    @ApiResponse(responseCode = "200", description = "200 OK")
    public ResponseEntity<ResponseBase<Void>> vendorAcceptance(
            @RequestBody VendorAcceptanceRequest request) {
        return null;
    }

    @PostMapping(value = PREFIX + CANCEL_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "배달 취소", description = "배달 취소")
    @ApiResponse(responseCode = "200", description = "200 OK")
    public ResponseEntity<ResponseBase<CancelResponse>> cancel(@RequestBody CancelRequest request) {
        return null;
    }

    @GetMapping(value = PREFIX + "/{deliveryRequestId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "배달 조회", description = "배달 조회")
    @ApiResponse(responseCode = "200", description = "200 OK")
    public ResponseEntity<ResponseBase<DeliveryRetrieveResponse>> retrieveDelivery(
            @Schema(description = "배달 요청 번호", example = "302547092140407810") @PathVariable
                    Long deliveryRequestId,
            @Schema(description = "요기요 주문 번호", example = "F240101130212") @RequestParam("order_number")
                    String orderNumber,
            @Schema(description = "배달대행사 배달 번호", example = "18051851296124")
                    @RequestParam("agency_delivery_id")
                    String agencyDeliveryId) {
        return null;
    }
}
