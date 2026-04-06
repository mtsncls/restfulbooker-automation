package core.config.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class RemoteDriverFactory {

    private RemoteDriverFactory() {}

    public static WebDriver create(String browser, String gridUrl) {
        URL url = validateGridUrl(gridUrl);
        return switch (browser.toLowerCase()) {
            case "chrome" -> new RemoteWebDriver(url, BrowserOptions.getChromeOptions());
            case "firefox" -> new RemoteWebDriver(url, BrowserOptions.getFirefoxOptions());
            case "edge" -> new RemoteWebDriver(url, BrowserOptions.getEdgeOptions());
            default -> throw new IllegalArgumentException("Unsupported remote browser: " + browser);
        };
    }

    private static URL validateGridUrl(String rawUrl) {
        try {
            return new URI(rawUrl).toURL();
        } catch (URISyntaxException | MalformedURLException e) {
            throw new IllegalStateException("Invalid Selenium Grid URL: " + rawUrl, e);
        }
    }
}
