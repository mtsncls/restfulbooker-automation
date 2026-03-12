package api.client;

import api.models.BookingPayload;
import io.restassured.response.Response;

public class BookingClient extends BaseApiClient {

    private static final String BOOKING = "/booking/";
    private static final String TOKEN = "token";

    public Response createBooking(BookingPayload payload) {
        return request()
                .body(payload)
                .post(BOOKING);
    }

    public Response getBooking(int id) {
        return request()
                .get(BOOKING + id);
    }

    public Response updateBooking(int id, BookingPayload payload, String token) {
        return request()
                .cookie(TOKEN, token)
                .body(payload)
                .put(BOOKING + id);
    }

    public Response deleteBooking(int id, String token) {
        return request()
                .cookie(TOKEN, token)
                .delete(BOOKING + id);
    }
}
