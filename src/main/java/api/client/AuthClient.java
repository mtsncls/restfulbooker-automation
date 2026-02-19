package api.client;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthClient extends BaseApiClient {

    private static class TokenResponse {
        @JsonProperty("token")
        private String token;
        public String getToken() { return token; }
    }

    public String createToken(String username, String password) {
        String payload = """
                {
                  "username": "%s",
                  "password": "%s"
                }
                """.formatted(username, password);

        return request()
                .body(payload)
                .post("/auth")
                .then()
                .statusCode(200)
                .extract()
                .as(TokenResponse.class)
                .getToken();
    }
}
