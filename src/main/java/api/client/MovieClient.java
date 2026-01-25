package api.client;

import io.qameta.allure.Step;

import static api.specs.CinescopeSpecs.apiRequestSpec;
import static api.specs.CinescopeSpecs.responseSpecOk;
import static io.restassured.RestAssured.given;

public class MovieClient {

    @Step("Удаление отзыва на фильм с айди {movieId}")
    public void deleteReview(Integer movieId, String userId, String accessToken) {
        given()
                .spec(apiRequestSpec())
                .auth().oauth2(accessToken)
                .queryParam("userId", userId)
                .when()
                .delete("/movies/{movieId}/reviews", movieId)
                .then()
                .spec(responseSpecOk());
    }
}

