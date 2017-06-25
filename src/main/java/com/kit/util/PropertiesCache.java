package com.kit.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by testu on 6/23/2017.
 */
public class PropertiesCache {
    private final Properties configProp = new Properties();
    private static final PropertiesCache INSTANCE = new PropertiesCache();

    private PropertiesCache() {
        //Private constructor to restrict new instances
        System.out.println("Read all properties from file");
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("test.properties");
        try {
            configProp.load(in);
        } catch (IOException e) {
            System.out.println("Can't read all properties from file. Exception: " + e);
        }
    }

    public static String getProperty(String key) {
        return INSTANCE.configProp.getProperty(key);
    }
}

