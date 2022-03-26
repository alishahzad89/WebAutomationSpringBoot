package com.cucumber.springboot.reader;

import com.cucumber.springboot.context.AppContext;

import java.util.Properties;

public class ConfigReader {

    private static Boolean firstExecution = true;
    public static Properties projectConfig = new Properties();
    public static ConfigReader configReader;

    private ConfigReader() {
    }

    public void getProjectConfiguration(String profile) {
        if (firstExecution) {
            populateConfig("environment/" + profile + ".properties");
            AppContext.hostUrl = projectConfig.getProperty("web.url");
            AppContext.environment = projectConfig.getProperty("web.environment");
            firstExecution = false;
        }
    }

    public static ConfigReader getInstance() {
        if (configReader == null) {
            configReader = new ConfigReader();
        }
        return configReader;
    }

    private Properties populateConfig(String resourcePath) throws RuntimeException {
        try {
            projectConfig.load(getClass().getClassLoader().getResourceAsStream(resourcePath));
        } catch (Exception e) {
            throw new RuntimeException("Unable to populate project configuration", e);
        }
        return projectConfig;
    }

}
