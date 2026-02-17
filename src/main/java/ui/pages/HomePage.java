package ui.pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private final By adminLoginLink = By.cssSelector("a[href='/#/admin']");
    private final By contactFormSection = By.id("contact");
    private final By bookingFormSection = By.cssSelector("#booking form");

    public HomePage() {
        super();
    }


    /**
     * Navigate to the Admin Login page.
     * Returns a new AdminLoginPage object.
     */
    public AdminLoginPage goToAdminLogin() {
        scrollIntoView(adminLoginLink);
        click(adminLoginLink);
        return new AdminLoginPage();
    }

    /**
     * Scrolls to the contact form section.
     * Useful for tests that validate contact form behavior.
     */
    public HomePage scrollToContactForm() {
        scrollIntoView(contactFormSection);
        return this;
    }

    /**
     * Scrolls to the booking form section.
     * Useful for tests that interact with the booking form.
     */
    public HomePage scrollToBookingForm() {
        scrollIntoView(bookingFormSection);
        return this;
    }

    /**
     * Verifies that the home page is loaded by checking
     * the presence of the booking form.
     */
    public boolean isLoaded() {
        return isDisplayed(bookingFormSection);
    }
}
