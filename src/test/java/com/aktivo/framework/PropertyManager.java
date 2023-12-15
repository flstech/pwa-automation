package com.aktivo.framework;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyManager {
    TestUtils utils = new TestUtils();

    public static Map<String, String> getProps() {
        try {
            String path = System.getProperty("user.dir") + "/config.properties";
            File config = new File(path);
            FileInputStream input;
            input = new FileInputStream(config.getAbsolutePath());
            Properties prop = new Properties();
            prop.load(input);
            Map<String, String> properties = new HashMap<>();
            for (Object key : prop.keySet()) {
                properties.put(key.toString(), prop.getProperty(key.toString()));
            }
            input.close();
            return properties;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
