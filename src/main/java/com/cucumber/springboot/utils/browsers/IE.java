package com.cucumber.springboot.utils.browsers;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class IE implements Browser {
    WebDriver driver = null;

    @Override
    public RemoteWebDriver execute(String environment) throws MalformedURLException {
        if (environment.equalsIgnoreCase("LOCAL")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (environment.equalsIgnoreCase("REMOTE")) {
            URL url = new URL("PassHUBURL");
            DesiredCapabilities cap = DesiredCapabilities.chrome();
            driver = new RemoteWebDriver(url, cap);
        }
        return (RemoteWebDriver) driver;
    }
}
