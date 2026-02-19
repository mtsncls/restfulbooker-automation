package api.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingDates {

    @JsonProperty("checkin")
    private final String checkIn;

    @JsonProperty("checkout")
    private final String checkOut;

    @JsonCreator
    public BookingDates(
            @JsonProperty("checkin") String checkIn,
            @JsonProperty("checkout") String checkOut
    ) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public static class Builder {
        private String checkIn;
        private String checkOut;

        public Builder checkIn(String checkIn) { this.checkIn = checkIn; return this; }
        public Builder checkOut(String checkOut) { this.checkOut = checkOut; return this; }

        public BookingDates build() {
            return new BookingDates(checkIn, checkOut);
        }
    }
}
