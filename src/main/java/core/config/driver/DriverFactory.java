package core.config.driver;

import core.config.ConfigManager;
import org.openqa.selenium.WebDriver;

public class DriverFactory {

    private DriverFactory(){}

    public static WebDriver createInstance() {
        String browser = ConfigManager.getBrowser().toLowerCase();
        String runMode = ConfigManager.getRunMode().toLowerCase();

        return switch (runMode) {
            case "local" -> LocalDriverFactory.create(browser);
            case "grid" -> RemoteDriverFactory.create(browser, ConfigManager.getGridUrl());
            default -> throw new IllegalArgumentException("Invalid run mode: " + runMode);
        };
    }
}
