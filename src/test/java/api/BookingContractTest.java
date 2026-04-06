package api;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.assertj.core.api.Assertions.assertThat;

import api.models.BookingPayload;
import api.models.BookingResponse;
import data.BookingFactory;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class BookingContractTest extends ApiBaseTest {

    private static final String CREATE_SCHEMA = "schemas/booking-response-schema.json";
    private static final String GET_SCHEMA = "schemas/booking-payload-schema.json";

    @Test
    public void createBookingResponseMatchesContract() {
        BookingPayload payload = BookingFactory.createRandomBooking();

        Response response = bookingClient.createBooking(payload);

        assertThat(response.statusCode())
                .as("Expected 200 status code for createBooking")
                .isEqualTo(200);

        response.then().assertThat()
                .body(matchesJsonSchemaInClasspath(CREATE_SCHEMA));
    }

    @Test
    public void getBookingResponseMatchesContract() {
        // First create a booking to ensure we have a valid ID
        BookingPayload payload = BookingFactory.createRandomBooking();
        BookingResponse created = bookingClient.createBooking(payload).as(BookingResponse.class);
        int bookingId = created.getBookingId();

        Response response = bookingClient.getBooking(bookingId);

        assertThat(response.statusCode())
                .as("Expected 200 status code for getBooking with id=" + bookingId)
                .isEqualTo(200);

        response.then().assertThat()
                .body(matchesJsonSchemaInClasspath(GET_SCHEMA));
    }
}
