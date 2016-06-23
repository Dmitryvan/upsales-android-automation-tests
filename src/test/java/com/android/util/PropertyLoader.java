package com.android.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertyLoader {

    private static Properties properties = new Properties();

    public static String loadProperty(String filePath, String name) {
        try {
            properties.load(new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(filePath), "UTF8")));
            return properties.getProperty(name);
        } catch (IOException e) {
            return e.getMessage();
        }
    }
}
