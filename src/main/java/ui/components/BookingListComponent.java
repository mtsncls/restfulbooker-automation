package ui.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BookingListComponent {

    private final WebDriver driver;

    private final By bookingCard = By.cssSelector(".row.hotel-room-info");
    private final By firstName = By.cssSelector("p[data-testid='firstname']");
    private final By lastName = By.cssSelector("p[data-testid='lastname']");
    private final By price = By.cssSelector("p[data-testid='price']");
    private final By deposit = By.cssSelector("p[data-testid='deposit']");
    private final By checkIn = By.cssSelector("p[data-testid='checkin']");
    private final By checkOut = By.cssSelector("p[data-testid='checkout']");
    private final By needs = By.cssSelector("p[data-testid='needs']");

    public BookingListComponent(WebDriver driver) {
        this.driver = driver;
    }

    public boolean containsBooking(String first, String last) {
        return getAllBookings().stream()
                .anyMatch(b -> b.firstName.equals(first) && b.lastName.equals(last));
    }

    public List<BookingListItem> getAllBookings() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.
                        visibilityOfElementLocated(By.cssSelector(".row.hotel-room-info")));

        return driver.findElements(bookingCard).stream()
                .map(this::mapToItem)
                .toList();
    }

    private BookingListItem mapToItem(WebElement card) {
        return new BookingListItem(
                card.findElement(firstName).getText(),
                card.findElement(lastName).getText(),
                card.findElement(price).getText(),
                card.findElement(deposit).getText(),
                card.findElement(checkIn).getText(),
                card.findElement(checkOut).getText(),
                card.findElement(needs).getText()
        );
    }

    public static class BookingListItem {
        public final String firstName;
        public final String lastName;
        public final String price;
        public final String deposit;
        public final String checkIn;
        public final String checkOut;
        public final String needs;

        public BookingListItem(String firstName, String lastName, String price,
                               String deposit, String checkIn, String checkOut, String needs) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.price = price;
            this.deposit = deposit;
            this.checkIn = checkIn;
            this.checkOut = checkOut;
            this.needs = needs;
        }
    }
}
