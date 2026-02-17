package ui.pages;

import api.models.Booking;
import org.openqa.selenium.By;

public class BookingFormPage extends BasePage {

    private final By firstName = By.id("firstname");
    private final By lastName = By.id("lastname");
    private final By email = By.id("email");
    private final By phone = By.id("phone");
    private final By bookButton = By.cssSelector("button[type='submit']");

    public BookingFormPage() {
        super();
    }

    public BookingFormPage enterFirstName(String value) {
        type(firstName, value);
        return this;
    }

    public BookingFormPage enterLastName(String value) {
        type(lastName, value);
        return this;
    }

    public BookingFormPage enterEmail(String value) {
        type(email, value);
        return this;
    }

    public BookingFormPage enterPhone(String value) {
        type(phone, value);
        return this;
    }

    public BookingFormPage fillBookingForm(Booking booking) {
        enterFirstName(booking.getFirstName());
        enterLastName(booking.getLastName());
        enterEmail(booking.getEmail());
        enterPhone(booking.getPhone());
        return this;
    }


    public void submitBooking() {
        click(bookButton);
    }
}
