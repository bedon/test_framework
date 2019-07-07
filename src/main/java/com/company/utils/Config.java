package com.company.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    public static Properties loadProperty(String propertyFile) {
        Properties property = new Properties();
        InputStream input;
        try {
            input = new FileInputStream(propertyFile);
            property.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return property;
    }
}
