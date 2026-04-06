package api.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingResponse {

    @JsonProperty("bookingid")
    private int bookingId;

    @JsonProperty("booking")
    private BookingPayload booking;

    public BookingResponse() {}

    @JsonCreator
    public BookingResponse(
            @JsonProperty("bookingid") int bookingId,
            @JsonProperty("booking") BookingPayload booking) {
        this.bookingId = bookingId;
        this.booking = booking;
    }

    public int getBookingId() { return bookingId; }
    public void setBookingId(int bookingId) { this.bookingId = bookingId; }

    public BookingPayload getBooking() { return booking; }
    public void setBooking(BookingPayload booking) { this.booking = booking; }
}
