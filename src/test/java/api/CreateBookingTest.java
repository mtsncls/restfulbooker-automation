package api;

import static org.assertj.core.api.Assertions.assertThat;

import api.models.BookingPayload;
import api.models.BookingResponse;
import data.BookingFactory;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class CreateBookingTest extends ApiBaseTest {

    @Test
    public void createBookingSuccessfully() {
        BookingPayload payload = BookingFactory.createRandomBooking();

        Response createResponse = bookingClient.createBooking(payload);
        assertThat(createResponse.statusCode()).isEqualTo(200);

        BookingResponse bookingResponse = createResponse.as(BookingResponse.class);
        int bookingId = bookingResponse.getBookingId();
        assertThat(bookingId).isPositive();

        Response getResponse = bookingClient.getBooking(bookingId);
        assertThat(getResponse.statusCode()).isEqualTo(200);

        BookingPayload bookingDetails = getResponse.as(BookingPayload.class);
        assertThat(bookingDetails.getFirstName()).isEqualTo(payload.getFirstName());
        assertThat(bookingDetails.getAdditionalNeeds()).isEqualTo(payload.getAdditionalNeeds());
    }
}
