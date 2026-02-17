package ui.pages;

import org.openqa.selenium.By;

public class ContactFormPage extends BasePage {

    private final By nameField = By.id("name");
    private final By emailField = By.id("email");
    private final By phoneField = By.id("phone");
    private final By subjectField = By.id("subject");
    private final By messageField = By.id("description");
    private final By submitButton = By.id("submitContact");
    private final By successMessage = By.cssSelector(".contact .alert-success");

    public ContactFormPage() {
        super();
    }

    public ContactFormPage enterName(String value) {
        type(nameField, value);
        return this;
    }

    public ContactFormPage enterEmail(String value) {
        type(emailField, value);
        return this;
    }

    public ContactFormPage enterPhone(String value) {
        type(phoneField, value);
        return this;
    }

    public ContactFormPage enterSubject(String value) {
        type(subjectField, value);
        return this;
    }

    public ContactFormPage enterMessage(String value) {
        type(messageField, value);
        return this;
    }

    public ContactFormPage fillForm(String name, String email, String phone, String subject, String message) {
        return enterName(name)
                .enterEmail(email)
                .enterPhone(phone)
                .enterSubject(subject)
                .enterMessage(message);
    }

    public void submit() {
        click(submitButton);
    }

    public boolean isSuccessMessageDisplayed() {
        return isDisplayed(successMessage);
    }
}
