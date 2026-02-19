package api.client;

import api.models.BookingPayload;
import api.models.BookingResponse;
import io.restassured.response.Response;

public class BookingClient extends BaseApiClient {

    private static final String BOOKING = "/booking/";
    private static final String TOKEN = "token";

    public BookingResponse createBooking(BookingPayload payload) {
        return request()
                .body(payload)
                .post(BOOKING)
                .then()
                .statusCode(200)
                .extract()
                .as(BookingResponse.class);
    }

    public BookingPayload getBooking(int id) {
        return request()
                .get(BOOKING + id)
                .then()
                .statusCode(200)
                .extract()
                .as(BookingPayload.class);
    }

    public BookingPayload updateBooking(int id, BookingPayload payload, String token) {
        return request()
                .cookie(TOKEN, token)
                .body(payload)
                .put(BOOKING + id)
                .then()
                .statusCode(200)
                .extract()
                .as(BookingPayload.class);
    }

    public boolean deleteBooking(int id, String token) {
        Response response = request()
                .cookie(TOKEN, token)
                .delete(BOOKING + id)
                .then()
                .statusCode(201)
                .extract()
                .response();

        return response.statusCode() == 201;
    }
}
