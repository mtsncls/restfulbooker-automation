package core.config.driver;

import core.config.ConfigManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
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
        switch (browser) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver(new ChromeOptions());
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver(new FirefoxOptions());
            }
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver(new EdgeOptions());
            }
            default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }

    private static WebDriver createRemoteDriver(String browser) throws RuntimeException {
        try {
             URL gridUrl = new URL(ConfigManager.getGridUrl());

             switch (browser) {
                 case "chrome" -> {return new RemoteWebDriver(gridUrl, new ChromeOptions());}

                 case "firefox" -> {return new RemoteWebDriver(gridUrl, new FirefoxOptions());}

                 case "edge" -> {return new RemoteWebDriver(gridUrl, new EdgeOptions());}

                 default -> throw new IllegalArgumentException("Unsupported browser for grid: " + browser);
             }

        } catch (MalformedURLException e){
                throw new IllegalArgumentException("Invalid grid URL: " + ConfigManager.getGridUrl(), e);
        }
    }
}
