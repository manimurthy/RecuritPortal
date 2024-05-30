package com.recuritportal.jspwebapp.Util;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Component
public class ConfigReader {
    private Properties properties = new Properties();

    public ConfigReader() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("edu_weights.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find edu_weights.properties");
                return;
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public int getIntProperty(String key) {
        return Integer.parseInt(properties.getProperty(key));
    }

    public int getEduIndex(String education) {
        switch (education.toLowerCase()) {
            case "high school":
                return getIntProperty("edu.index.highschool");
            case "under graduate":
                return getIntProperty("edu.index.undergraduate");
            case "graduate":
                return getIntProperty("edu.index.graduate");
            case "post graduate":
                return getIntProperty("edu.index.postgraduate");
            case "doctorate":
                return getIntProperty("edu.index.doctorate");
            default:
                throw new IllegalArgumentException("Unknown education qualification: " + education);
        }
    }
}
