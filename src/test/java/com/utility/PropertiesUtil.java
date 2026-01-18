package com.utility;

import com.constants.Env;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

    public static String readProperty(Env env, String propertyName) {
        Properties prop = new Properties();
        String path = "config/" + env + ".properties";
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
        try {
            prop.load(is);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return prop.getProperty(propertyName.toUpperCase());
    }
}
