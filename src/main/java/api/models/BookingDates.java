package api.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingDates {

    @JsonProperty("checkin")
    private String checkIn;

    @JsonProperty("checkout")
    private String checkOut;

    public BookingDates() {}

    @JsonCreator
    public BookingDates(
            @JsonProperty("checkin") String checkIn,
            @JsonProperty("checkout") String checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public String getCheckIn() { return checkIn; }
    public void setCheckIn(String checkIn) { this.checkIn = checkIn; }

    public String getCheckOut() { return checkOut; }
    public void setCheckOut(String checkOut) { this.checkOut = checkOut; }

    // Static Builder to keep existing code working
    public static BookingDatesBuilder builder() {
        return new BookingDatesBuilder();
    }

    public static class BookingDatesBuilder {
        private String checkIn;
        private String checkOut;

        public BookingDatesBuilder checkIn(String checkIn) {
            this.checkIn = checkIn;
            return this;
        }

        public BookingDatesBuilder checkOut(String checkOut) {
            this.checkOut = checkOut;
            return this;
        }

        public BookingDates build() {
            return new BookingDates(checkIn, checkOut);
        }
    }
}
