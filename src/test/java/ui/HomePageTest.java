package ui;

import org.testng.Assert;
import org.testng.annotations.Test;
import runners.BaseTest;
import ui.pages.HomePage;

public class HomePageTest extends BaseTest {

    @Test
    public void verifyHomePageLoads() {
        HomePage home = new HomePage();

        Assert.assertTrue(home.isLoaded(), "Home page did not load correctly");

        home.scrollToContactForm();

        Assert.assertTrue(home.isLoaded(), "Contact form not visible after scroll");
    }
}
