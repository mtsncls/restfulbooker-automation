package api.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingResponse {

    @JsonProperty("bookingid")
    private final int bookingId;

    @JsonProperty("booking")
    private final BookingPayload booking;

    @JsonCreator
    public BookingResponse(
            @JsonProperty("bookingid") int bookingId,
            @JsonProperty("booking") BookingPayload booking
    ) {
        this.bookingId = bookingId;
        this.booking = booking;
    }

    public int getBookingId() {
        return bookingId;
    }

    public BookingPayload getBooking() {
        return booking;
    }
}
