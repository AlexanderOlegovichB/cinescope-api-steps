package api.client;

import api.dto.auth.AuthResponseDto;
import api.dto.auth.LoginRequestDto;
import io.qameta.allure.Step;

import static api.specs.CinescopeSpecs.authRequestSpec;
import static api.specs.CinescopeSpecs.responseSpecOk;
import static io.restassured.RestAssured.given;

public class UserApiClient {

    @Step("Авторизация: логин по email {request.email}")
    public AuthResponseDto loginAndGetToken(LoginRequestDto request) {
        return given()
                .spec(authRequestSpec())
                .body(request)
                .when()
                .post("/login")
                .then()
                .spec(responseSpecOk())
                .extract()
                .as(AuthResponseDto.class);
    }
}