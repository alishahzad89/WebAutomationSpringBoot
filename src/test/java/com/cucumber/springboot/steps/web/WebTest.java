package com.cucumber.springboot.steps.web;

import com.cucumber.springboot.utils.DriverService;
import org.apache.commons.io.FileUtils;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class WebTest {
    protected WebDriver driver;
    SoftAssertions softAssertions = new SoftAssertions();

    protected WebTest() {
        try {
            driver = DriverService.getDriver();
            driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
            driver.manage().window().maximize();

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    protected void getElementScreenshot(WebElement element, String path) throws IOException {
        File actualLogo = element.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(actualLogo, new File(path));
    }

    protected String getElementText(WebElement element) {
        return element.getText();
    }

    protected Map<String, String> getTableDetails(WebElement table, String conditionalElement) {

        Map<String, String> tableData = new HashMap<>();
        boolean cont = true;

        do {
            List<WebElement> rows = table.findElements(By.xpath("tr"));
            for (int i = 0; i < rows.size(); i++) {
                List<WebElement> columns = rows.get(i).findElements(By.xpath("td"));
                tableData.put(columns.get(0).getText(), columns.get(1).getText());
            }

            if (elementPresent(conditionalElement)) {
                driver.findElement(By.xpath(conditionalElement)).click();
            } else {
                cont = false;
            }

        } while (cont);

        return tableData;

    }

    protected Boolean elementPresent(String xPath) {
        return driver.findElements(By.xpath(xPath)).size() > 0;
    }

    protected Boolean elementPresent(WebElement element) {

        try {
            element.isDisplayed();
            return true;

        } catch (NotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}

