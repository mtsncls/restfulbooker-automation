package ui.pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private final By adminLoginLink = By.cssSelector("a[href='/#/admin']");
    private final By contactFormSection = By.id("contact");
    private final By bookingFormSection = By.cssSelector("#booking form");

    public HomePage() {
        super();
    }

    public AdminLoginPage goToAdminLogin() {
        scrollIntoView(adminLoginLink);
        click(adminLoginLink);
        return new AdminLoginPage();
    }

    public HomePage scrollToContactForm() {
        scrollIntoView(contactFormSection);
        return this;
    }

    public HomePage scrollToBookingForm() {
        scrollIntoView(bookingFormSection);
        return this;
    }

    public boolean isLoaded() {
        return isDisplayed(bookingFormSection);
    }
}
