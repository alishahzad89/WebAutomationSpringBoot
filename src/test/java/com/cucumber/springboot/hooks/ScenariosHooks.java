package com.cucumber.springboot.hooks;

import com.cucumber.springboot.context.AppContext;
import com.cucumber.springboot.reader.ConfigReader;
import com.cucumber.springboot.utils.DriverService;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.IOException;

public class ScenariosHooks {

    @Value("${profile.active}")
    private String activeProfile;

    @Value("${web.browser}")
    private String browser;

    private RemoteWebDriver driver = null;
   @Before
    public void beforeScenarios(Scenario scn) throws Exception {
      ConfigReader.getInstance().getProjectConfiguration(activeProfile);
      AppContext.profile = activeProfile;
      AppContext.browser = browser;
       if (null == driver) {
           driver = DriverService.getDriver();
       }
    }

    @After
    public void afterScenario(Scenario scn) throws Exception {
        if (scn.isFailed()) {
            File file = driver.getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(file, new File("FailedScreenshot.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        driver.quit();
    }
}
