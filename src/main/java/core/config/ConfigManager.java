package core.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
    private ConfigManager() {
    }

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigManager.class
                .getClassLoader()
                .getResourceAsStream("config.properties")) {

            if (input == null) {
                throw new IllegalStateException("config.properties not found in resources folder");
            }

            properties.load(input);

        } catch (IOException e) {
            throw new java.io.UncheckedIOException("Failed to load config.properties", e);
        }
    }

    public static String get(String key) {
        return System.getProperty(key, properties.getProperty(key));
    }

    public static String getBrowser() {
        return get("browser");
    }

    public static String getRunMode() {
        return get("runMode");
    }

    public static String getGridUrl() {
        return get("gridUrl");
    }

    public static String getBaseUrl() {
        return get("baseUrl");
    }

    public static String getApiBaseUrl() {
        return get("apiBaseUrl");
    }
}
