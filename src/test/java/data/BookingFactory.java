package data;

import api.models.BookingDates;
import api.models.BookingPayload;

public class BookingFactory {

    public static BookingPayload createDefaultBooking() {
        BookingDates dates = new BookingDates.Builder()
                .checkIn("2024-01-01")
                .checkOut("2024-01-05")
                .build();

        return new BookingPayload.Builder()
                .firstName("Matias")
                .lastName("Perez")
                .totalPrice(150)
                .depositPaid(true)
                .bookingDates(dates)
                .additionalNeeds("Breakfast")
                .build();
    }
}
