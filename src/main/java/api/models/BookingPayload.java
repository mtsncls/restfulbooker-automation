package api.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingPayload {

    @JsonProperty("firstname")
    private final String firstName;

    @JsonProperty("lastname")
    private final String lastName;

    @JsonProperty("totalprice")
    private final int totalPrice;

    @JsonProperty("depositpaid")
    private final boolean depositPaid;

    @JsonProperty("bookingdates")
    private final BookingDates bookingDates;

    @JsonProperty("additionalneeds")
    private final String additionalNeeds;

    @JsonCreator
    public BookingPayload(
            @JsonProperty("firstname") String firstName,
            @JsonProperty("lastname") String lastName,
            @JsonProperty("totalprice") int totalPrice,
            @JsonProperty("depositpaid") boolean depositPaid,
            @JsonProperty("bookingdates") BookingDates bookingDates,
            @JsonProperty("additionalneeds") String additionalNeeds
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.totalPrice = totalPrice;
        this.depositPaid = depositPaid;
        this.bookingDates = bookingDates;
        this.additionalNeeds = additionalNeeds;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getTotalPrice() { return totalPrice; }
    public boolean isDepositPaid() { return depositPaid; }
    public BookingDates getBookingDates() { return bookingDates; }
    public String getAdditionalNeeds() { return additionalNeeds; }

    public static class Builder {
        private String firstName;
        private String lastName;
        private int totalPrice;
        private boolean depositPaid;
        private BookingDates bookingDates;
        private String additionalNeeds;

        public Builder firstName(String firstName) { this.firstName = firstName; return this; }
        public Builder lastName(String lastName) { this.lastName = lastName; return this; }
        public Builder totalPrice(int totalPrice) { this.totalPrice = totalPrice; return this; }
        public Builder depositPaid(boolean depositPaid) { this.depositPaid = depositPaid; return this; }
        public Builder bookingDates(BookingDates bookingDates) { this.bookingDates = bookingDates; return this; }
        public Builder additionalNeeds(String additionalNeeds) { this.additionalNeeds = additionalNeeds; return this; }

        public BookingPayload build() {
            return new BookingPayload(firstName, lastName, totalPrice, depositPaid, bookingDates, additionalNeeds);
        }
    }
}
