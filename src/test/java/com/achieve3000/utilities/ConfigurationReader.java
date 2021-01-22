package com.achieve3000.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    // This class is used for reading the data from

    private static Properties properties;

    static {

        String path = "configuration.properties";
        try {
            FileInputStream stream = new FileInputStream(path);
            properties = new Properties();

                properties.load(stream);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }

}
