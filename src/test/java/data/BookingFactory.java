package data;

import api.models.BookingDates;
import api.models.BookingPayload;
import com.github.javafaker.Faker;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class BookingFactory {

    private static final Faker faker = new Faker();
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static BookingPayload createRandomBooking() {
        BookingDates dates = BookingDates.builder()
                .checkIn(sdf.format(faker.date().future(10, TimeUnit.DAYS)))
                .checkOut(sdf.format(faker.date().future(20, 11, TimeUnit.DAYS)))
                .build();

        return BookingPayload.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .totalPrice(faker.number().numberBetween(100, 500))
                .depositPaid(true)
                .bookingDates(dates)
                .additionalNeeds("Breakfast")
                .build();
    }
}
