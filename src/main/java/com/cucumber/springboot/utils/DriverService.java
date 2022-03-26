package com.cucumber.springboot.utils;

import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverService {

    private static RemoteWebDriver _driver = null;

    private DriverService() {
    }

    public static RemoteWebDriver getDriver() throws Exception {
        if (null == _driver) {
            _driver = DriverFactory.getDriver();
        } else if (null != _driver && _driver.getSessionId() == null) {
            _driver = DriverFactory.getDriver();
        }
        return _driver;
    }
}
