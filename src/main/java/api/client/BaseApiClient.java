package api.client;

import core.config.ConfigManager;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.mapper.ObjectMapperType;
import io.qameta.allure.restassured.AllureRestAssured;

public abstract class BaseApiClient {

    static {
        RestAssured.config = RestAssured.config()
                .objectMapperConfig(new ObjectMapperConfig(ObjectMapperType.JACKSON_2));
    }

    protected RequestSpecification request() {
        return RestAssured.given()
                .filter(new AllureRestAssured())
                .baseUri(ConfigManager.getApiBaseUrl())
                .contentType("application/json")
                .log().all();
    }
}
