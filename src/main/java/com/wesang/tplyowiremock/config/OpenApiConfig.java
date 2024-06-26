package com.wesang.tplyowiremock.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.swagger.v3.core.jackson.ModelResolver;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class OpenApiConfig {
    private static final String TITLE = "요기요와 3PL 배달대행사 간 연동 API(V2)-배달대행사";
    private static final String DESCRIPTION = """
        ## 개요
        - 요기요와 3PL 배달 대행사 간 연동을 위해 3PL사에서 제공되어야 하는 API 목록입니다.
        - 통신 프로토콜: 본 API를 위한 통신은 HTTP 프로토콜을 이용하여 POST 방식으로 데이터를 전달합니다.
        - 접속 정보: 해당 API는 사전에 제공받은 API Key와 Secret을 헤더에 셋팅후 호출해야 합니다.
        - 메시지 포맷: 본 연동 API의 Request, Response Data는 header영역과 JSON 형태의 payload 를 지정하는 data 영역으로 구성되며, UTF-8을 기본 Character Set 으로 합니다.
        ## 공통 헤더
        | 번호  | 타입     | 길이  | 필수  | Key             | Value                                 | 비고                                              |
        |-----|--------|-----|-----|-----------------|---------------------------------------|-------------------------------------------------|
        | 1   | String | 16  | Y   | Content-Type    | application/json                      |                                                 |
        | 2   | String | 4   | N   | Accept-Encoding | gzip                                  | 클라이언트 프로그램이 gzip 인코딩 방식을 지원하지 않는다면 보내지 않아도 됩니다. |
        | 3   | String | 40  | Y   | apikey          | Tdfesfer4Eb09DIf (샘플)                 |                                                 |
        | 4   | String | 40  | Y   | secret          | kF83whKkuef37yo3rjp0er32rh7YgYf8 (샘플) | 
            """;

    @Bean
    GroupedOpenApi deliveryApi() {
        return GroupedOpenApi.builder()
                .group("Delivery-API")
                .pathsToMatch("/yogiyo/api/v2/delivery/**")
                .addOpenApiCustomizer(openApi -> openApi.getInfo().setTitle(TITLE + "-배송 API"))
                .build();
    }

    @Bean
    public ModelResolver modelResolver() {
        ObjectMapper objectMapper = new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .registerModule(new JavaTimeModule());
        return new ModelResolver(objectMapper);
    }
}
