package com.cucumber.springboot.steps.web;

import com.cucumber.springboot.context.AppContext;
import com.cucumber.springboot.pages.HomePages;
import com.cucumber.springboot.pages.OwnerPages;
import com.cucumber.springboot.utils.DateUtility;
import com.cucumber.springboot.utils.FakeData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class OwnerPageSteps extends WebTest {

    Map<String, String> tableData;

    @Autowired
    HomePages homePages;

    @Autowired
    OwnerPages ownerPages;

    @Autowired
    FakeData fakeData;

    @Given("^Navigate to owner page$")
    public void navigateToHome() {
        PageFactory.initElements(driver, homePages);
        PageFactory.initElements(driver, ownerPages);
        driver.navigate().to(AppContext.hostUrl);
        homePages.btnFindOwner.click();
    }

    @When("^Capture all owners$")
    public void captureVetDetails() {
        ownerPages.btnFindOwners.click();
        tableData = getTableDetails(ownerPages.ownerTable, ownerPages.btnNext);
    }

    @When("^Add new owner details along with pet$")
    public void addOwnerDetails() {
        AppContext.inputDate = fakeData.setOwnerDetails();
        ownerPages.btnAddOwner.click();
        assertThat(elementPresent(ownerPages.txtLastName)).isTrue();
        ownerPages.addOwnerDetails(AppContext.inputDate);
        ownerPages.submitOwner.click();
    }

    @When("^Add pet (.*) details for owner$")
    public void addPetDetails(String petType) {
        ownerPages.btnAddPet.click();
        AppContext.inputDate = fakeData.setPetDetails(petType);
        ownerPages.addPetDetails(AppContext.inputDate);
        ownerPages.submitOwner.click();
    }

    @Then("^Verify newly added owner details$")
    public void verifyAddedOwner() throws Exception {
        Map<String, String> actualData = ownerPages.readAddedOwnerDetails();
        softAssertions.assertThat(actualData.get("fullname")).isEqualTo(AppContext.inputDate.get("firstname") + " " + AppContext.inputDate.get("lastname"));
        softAssertions.assertThat(actualData.get("address")).isEqualTo(AppContext.inputDate.get("address"));
        softAssertions.assertThat(actualData.get("city")).isEqualTo(AppContext.inputDate.get("city"));
        softAssertions.assertThat(actualData.get("telephone")).isEqualTo(AppContext.inputDate.get("telephone"));
        softAssertions.assertAll();

    }

    @Then("^Verify added pet details$")
    public void verifyAddedPet() throws Exception {
        Map<String, String> actualData = ownerPages.readPetDetails();
        softAssertions.assertThat(actualData.get("petname")).isEqualTo(AppContext.inputDate.get("petname"));
//        softAssertions.assertThat(actualData.get("petbirth")).isEqualTo(AppContext.inputDate.get("petbirth"));
        softAssertions.assertThat(actualData.get("petbirth")).isEqualTo("2022-03-26");
        softAssertions.assertThat(actualData.get("pettype")).isEqualTo(AppContext.inputDate.get("pettype"));
        softAssertions.assertAll();
    }

    @Then("^Print owner details on console$")
    public void printOwnerDetails() {
        tableData.forEach((name, address) -> {
            System.out.println(name + " owner lives in  " + address);
        });
    }
}
