package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties =
            new Properties();

    static {

        try (InputStream inputStream =
                ConfigReader.class
                        .getClassLoader()
                        .getResourceAsStream("config.properties")) {

            if (inputStream == null) {
                throw new RuntimeException(
                        "config.properties file was not found."
                );
            }

            properties.load(inputStream);

        } catch (IOException exception) {

            throw new RuntimeException(
                    "Unable to load config.properties.",
                    exception
            );
        }
    }

    public static String getProperty(String key) {

        String value = properties.getProperty(key);

        if (value == null) {
            throw new RuntimeException(
                    "Property not found: " + key
            );
        }

        return value;
    }
}