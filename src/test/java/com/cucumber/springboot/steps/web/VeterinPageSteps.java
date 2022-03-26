package com.cucumber.springboot.steps.web;

import com.cucumber.springboot.context.AppContext;
import com.cucumber.springboot.pages.HomePages;
import com.cucumber.springboot.pages.VeterinPages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class VeterinPageSteps extends WebTest {

    static Map<String, String> tableData;

    @Autowired
    HomePages homePages;

    @Autowired
    VeterinPages vetPages;

    @Given("^Navigate to veterin page$")
    public void navigateToHome() {
        PageFactory.initElements(driver, homePages);
        PageFactory.initElements(driver, vetPages);
        driver.navigate().to(AppContext.hostUrl);
        homePages.btnFindVeterin.click();
        assertThat(getElementText(vetPages.vetHeader)).isEqualTo("Veterinarians");
    }

    @When("^Capture veterin along with specialities$")
    public void captureVetDetails() {
        tableData = getTableDetails(vetPages.vetTable, vetPages.btnNext);
    }

    @Then("^Print vetrin details on console$")
    public void printVetDetails() {
        tableData.forEach((name, speciality) -> {
            System.out.println(name + " has specialties in " + speciality);
        });
    }
}
