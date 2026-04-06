package core.config.driver;

import core.config.ConfigManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class DriverFactory {

    private DriverFactory(){}

    public static WebDriver createInstance() {
        String browser = ConfigManager.getBrowser().toLowerCase();
        String runMode = ConfigManager.getRunMode().toLowerCase();

        return switch (runMode) {
            case "local" -> createLocalDriver(browser);
            case "grid" -> createRemoteDriver(browser);
            default -> throw new IllegalArgumentException("Invalid run mode: " + runMode);
        };
    }

    private static WebDriver createLocalDriver(String browser) {
        return switch (browser.toLowerCase()) {
            case "chrome" -> new ChromeDriver(chromeOptions());
            case "firefox" -> new FirefoxDriver(firefoxOptions());
            case "edge" -> new EdgeDriver(edgeOptions());
            default -> throw new IllegalArgumentException("Unsupported local browser: " + browser);
        };
    }

    private static WebDriver createRemoteDriver(String browser) {
        URL gridUrl = validateGridUrl(ConfigManager.getGridUrl());

        return switch (browser.toLowerCase()) {
            case "chrome" -> new RemoteWebDriver(gridUrl, chromeOptions());
            case "firefox" -> new RemoteWebDriver(gridUrl, firefoxOptions());
            case "edge" -> new RemoteWebDriver(gridUrl, edgeOptions());
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

    private static ChromeOptions chromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu", "--no-sandbox", "--disable-dev-shm-usage");
        
        String extraArgs = System.getProperty("chrome.args", "");
        if (!extraArgs.isEmpty()) {
            for (String arg : extraArgs.split(",")) {
                options.addArguments(arg.trim());
            }
        }
        
        if (isHeadless()) {
            options.addArguments("--headless=new");
        }
        return options;
    }

    private static FirefoxOptions firefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        if (isHeadless()) {
            options.addArguments("-headless");
        }
        return options;
    }

    private static EdgeOptions edgeOptions() {
        EdgeOptions options = new EdgeOptions();
        if (isHeadless()) {
            options.addArguments("--headless");
        }
        return options;
    }

    private static boolean isHeadless() {
        return Boolean.parseBoolean(System.getProperty("headless", "false"));
    }

}
