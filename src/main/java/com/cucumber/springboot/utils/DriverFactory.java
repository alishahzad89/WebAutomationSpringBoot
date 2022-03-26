package com.cucumber.springboot.utils;

import com.cucumber.springboot.context.AppContext;
import com.cucumber.springboot.utils.browsers.Browser;
import com.cucumber.springboot.utils.browsers.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public static RemoteWebDriver getDriver() throws Exception {
        RemoteWebDriver driver = null;
        driver = getWebDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
        return driver;
    }

    private static RemoteWebDriver getWebDriver() throws Exception {
        WebDriver driver = null;
        Browser targetBrowser = BrowserFactory
                .getOperation(AppContext.browser)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Browser"));
        driver = targetBrowser.execute(AppContext.environment);
        return (RemoteWebDriver) driver;
    }
}
