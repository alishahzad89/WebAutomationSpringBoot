package com.cucumber.springboot.steps.web;

import com.cucumber.springboot.context.AppContext;
import com.cucumber.springboot.pages.HomePages;
import com.cucumber.springboot.utils.ImageCompare;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;


import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class HomePageSteps extends WebTest {

    @Autowired
    HomePages homePages;

    @Given("^Navigate to home page$")
    public void navigateToHome() {
        PageFactory.initElements(driver, homePages);
        driver.navigate().to(AppContext.hostUrl);
    }

    @When("^Capture home logo$")
    public void captureHomeLogo() throws IOException {
        getElementScreenshot(homePages.homeLogo, "src/test/resources/ActualHomeLogo.png");

    }

    @Then("^Validate home logo is correct$")
    public void validateHomeLogo() throws IOException {
        Boolean imageDiff = ImageCompare.compareImages(new File("src/test/resources/ExpectedHomeLogo.png"), new File("src/test/resources/ActualHomeLogo.png"));
        assertThat(imageDiff).as("Validate home logo image").isFalse();
    }
}
