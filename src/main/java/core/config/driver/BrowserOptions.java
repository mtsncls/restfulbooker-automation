package core.config.driver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserOptions {

    private BrowserOptions() {}

    public static ChromeOptions getChromeOptions() {
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

    public static FirefoxOptions getFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        if (isHeadless()) {
            options.addArguments("-headless");
        }
        return options;
    }

    public static EdgeOptions getEdgeOptions() {
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
