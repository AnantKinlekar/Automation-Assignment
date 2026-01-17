package com.utility;

import com.constants.Environment;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

    public static String readProperty(Environment environment, String propertyName) {
        Properties prop = new Properties();
        String path = "config/" + environment + ".properties";
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
        try {
            prop.load(is);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return prop.getProperty(propertyName.toUpperCase());
    }
}
