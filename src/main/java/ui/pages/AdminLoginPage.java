package ui.pages;

import org.openqa.selenium.By;

public class AdminLoginPage extends BasePage {

    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("doLogin");

    public AdminLoginPage() {
        super();
    }

    public AdminLoginPage enterUsername(String username) {
        type(usernameField, username);
        return this;
    }

    public AdminLoginPage enterPassword(String password) {
        type(passwordField, password);
        return this;
    }

    public AdminDashboardPage clickLogin() {
        click(loginButton);
        return new AdminDashboardPage();
    }

    public AdminDashboardPage loginAs(String username, String password) {
        return enterUsername(username)
                .enterPassword(password)
                .clickLogin();
    }
}
