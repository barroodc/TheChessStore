package com.solvd.onlinestore.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CredentialValues {
    public CredentialValues(String s) {
    }

    private static final Logger logger = LogManager.getLogger(CredentialValues.class.getName());
    private String driver = "db.driver";
    private String url = "db.url";
    private String name = "db.name";
    private String password = "db.password";

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }


    public void getPropValues(String value) throws IOException {
        Properties properties = new Properties();
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(value);
            if (inputStream != null) {
                properties.load(inputStream);
            }
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");
            name = properties.getProperty("name");
            password = properties.getProperty("password");
        } catch (IOException e) {
            logger.error("Exception:  " + e);
        }

    }
}
