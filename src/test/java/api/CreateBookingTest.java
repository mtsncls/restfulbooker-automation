package api;

import api.client.BookingClient;
import api.models.BookingDates;
import api.models.BookingPayload;
import api.models.BookingResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateBookingTest {

    @Test
    public void createBookingSuccessfully() {

        BookingDates dates = new BookingDates.Builder()
                .checkIn("2024-01-01")
                .checkOut("2024-01-05")
                .build();

        BookingPayload payload = new BookingPayload.Builder()
                .firstName("Matias")
                .lastName("Perez")
                .totalPrice(150)
                .depositPaid(true)
                .bookingDates(dates)
                .additionalNeeds("Breakfast")
                .build();

        BookingClient client = new BookingClient();
        BookingResponse response = client.createBooking(payload);
        BookingPayload bookingDetails = client.getBooking(response.getBookingId());

        Assert.assertTrue(response.getBookingId() > 0);
        Assert.assertEquals(bookingDetails.getFirstName(), "Matias");
        Assert.assertEquals(bookingDetails.getAdditionalNeeds(), "Breakfast");
    }
}
