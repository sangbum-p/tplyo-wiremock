package com.wesang.tplyowiremock.delivery.response;

import jakarta.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;

import com.wesang.tplyowiremock.delivery.enums.ResultCode;

public record ResponseBase<T>(
        @NotNull @Schema(description = "응답 결과", example = "SUCCESS") ResultCode result,
        @Schema(description = "에러 정보, result가 ERROR인 경우 필수 값입니다") Error error,
        @Schema(description = "응답 데이터 정보, result가 SUCCESS인 경우 필수 값입니다") T data) {

    public record Error(
            @NotNull @Schema(description = "에러 타입", example = "INTERNAL_ERROR") String type,
            @NotNull @Schema(description = "에러 코드", example = "INTERNAL_ERROR") String code,
            @NotNull @Schema(description = "에러 메시지", example = "예상하지 못한 에러가 발생하였습니다.") String message) {}
}
