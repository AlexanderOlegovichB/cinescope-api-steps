package api.helper;

import api.client.UserApiClient;
import api.dto.auth.AuthResponseDto;
import api.dto.auth.LoginRequestDto;
import io.qameta.allure.Step;

public class AuthHelper {
    private final UserApiClient authApiClient = new UserApiClient();

    @Step("Авторизация через API пользователем {email}")
    public AuthResponseDto login(String email, String password) {
        LoginRequestDto request = LoginRequestDto.builder()
                .email(email)
                .password(password)
                .build();

        return authApiClient.loginAndGetToken(request);
    }
}
