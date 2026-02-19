package api.client;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.mapper.ObjectMapperType;

public abstract class BaseApiClient {

    static {
        RestAssured.config = RestAssured.config()
                .objectMapperConfig(new ObjectMapperConfig(ObjectMapperType.JACKSON_2));
    }

    protected RequestSpecification request() {
        return RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .contentType("application/json")
                .log().all();
    }
}
