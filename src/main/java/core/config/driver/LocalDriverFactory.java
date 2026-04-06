package core.config.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocalDriverFactory {

    private LocalDriverFactory() {}

    public static WebDriver create(String browser) {
        return switch (browser.toLowerCase()) {
            case "chrome" -> new ChromeDriver(BrowserOptions.getChromeOptions());
            case "firefox" -> new FirefoxDriver(BrowserOptions.getFirefoxOptions());
            case "edge" -> new EdgeDriver(BrowserOptions.getEdgeOptions());
            default -> throw new IllegalArgumentException("Unsupported local browser: " + browser);
        };
    }
}
