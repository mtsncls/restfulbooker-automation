package api.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingPayload {

    @JsonProperty("firstname")
    private String firstName;

    @JsonProperty("lastname")
    private String lastName;

    @JsonProperty("totalprice")
    private int totalPrice;

    @JsonProperty("depositpaid")
    private boolean depositPaid;

    @JsonProperty("bookingdates")
    private BookingDates bookingDates;

    @JsonProperty("additionalneeds")
    private String additionalNeeds;

    public BookingPayload() {}

    @JsonCreator
    public BookingPayload(
            @JsonProperty("firstname") String firstName,
            @JsonProperty("lastname") String lastName,
            @JsonProperty("totalprice") int totalPrice,
            @JsonProperty("depositpaid") boolean depositPaid,
            @JsonProperty("bookingdates") BookingDates bookingDates,
            @JsonProperty("additionalneeds") String additionalNeeds) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.totalPrice = totalPrice;
        this.depositPaid = depositPaid;
        this.bookingDates = bookingDates;
        this.additionalNeeds = additionalNeeds;
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getTotalPrice() { return totalPrice; }
    public void setTotalPrice(int totalPrice) { this.totalPrice = totalPrice; }

    public boolean isDepositPaid() { return depositPaid; }
    public void setDepositPaid(boolean depositPaid) { this.depositPaid = depositPaid; }

    public BookingDates getBookingDates() { return bookingDates; }
    public void setBookingDates(BookingDates bookingDates) { this.bookingDates = bookingDates; }

    public String getAdditionalNeeds() { return additionalNeeds; }
    public void setAdditionalNeeds(String additionalNeeds) { this.additionalNeeds = additionalNeeds; }

    public static BookingPayloadBuilder builder() {
        return new BookingPayloadBuilder();
    }

    public static class BookingPayloadBuilder {
        private String firstName;
        private String lastName;
        private int totalPrice;
        private boolean depositPaid;
        private BookingDates bookingDates;
        private String additionalNeeds;

        public BookingPayloadBuilder firstName(String firstName) { this.firstName = firstName; return this; }
        public BookingPayloadBuilder lastName(String lastName) { this.lastName = lastName; return this; }
        public BookingPayloadBuilder totalPrice(int totalPrice) { this.totalPrice = totalPrice; return this; }
        public BookingPayloadBuilder depositPaid(boolean depositPaid) { this.depositPaid = depositPaid; return this; }
        public BookingPayloadBuilder bookingDates(BookingDates bookingDates) { this.bookingDates = bookingDates; return this; }
        public BookingPayloadBuilder additionalNeeds(String additionalNeeds) { this.additionalNeeds = additionalNeeds; return this; }

        public BookingPayload build() {
            return new BookingPayload(firstName, lastName, totalPrice, depositPaid, bookingDates, additionalNeeds);
        }
    }
}
