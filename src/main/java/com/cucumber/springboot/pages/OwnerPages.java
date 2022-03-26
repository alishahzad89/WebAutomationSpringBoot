package com.cucumber.springboot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class OwnerPages {

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement btnFindOwners;

    @FindBy(xpath = "//table[@class='table table-striped']/tbody")
    public WebElement ownerTable;

    public String btnNext = "//a[@class='fa fa-step-forward']";

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    public WebElement btnAddOwner;

    @FindBy(id = "firstName")
    public WebElement txtFirstName;

    @FindBy(id = "lastName")
    public WebElement txtLastName;

    @FindBy(id = "address")
    public WebElement txtAddress;

    @FindBy(id = "city")
    public WebElement txtCity;

    @FindBy(id = "telephone")
    public WebElement txtTelephone;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement submitOwner;

    @FindBy(xpath = "//a[@class='btn btn-primary'][2]")
    public WebElement btnAddPet;

    @FindBy(id = "name")
    public WebElement txtPetName;

    @FindBy(id = "birthDate")
    public WebElement txtBirthDate;

    @FindBy(xpath = "//select[@id='type']")
    public WebElement drdType;

    @FindBy(xpath = "//dl[@class='dl-horizontal']/dd")
    public List<WebElement> petDetails;


    public void addOwnerDetails(Map<String, String> inputData) {
        txtFirstName.sendKeys(inputData.get("firstname"));
        txtLastName.sendKeys(inputData.get("lastname"));
        txtAddress.sendKeys(inputData.get("address"));
        txtCity.sendKeys(inputData.get("city"));
        txtTelephone.sendKeys(inputData.get("telephone"));
    }

    public Map<String, String> readAddedOwnerDetails() throws Exception{
        Map<String, String> tableData = new HashMap<>();
        List<WebElement> rows = ownerTable.findElements(By.xpath("tr"));
        tableData.put("fullname", rows.get(0).findElements(By.xpath("td")).get(0).getText());
        tableData.put("address", rows.get(1).findElements(By.xpath("td")).get(0).getText());
        tableData.put("city", rows.get(2).findElements(By.xpath("td")).get(0).getText());
        tableData.put("telephone", rows.get(3).findElements(By.xpath("td")).get(0).getText());
        return tableData;
    }

    public void addPetDetails(Map<String, String> inputData) {
        txtPetName.sendKeys(inputData.get("petname"));
        txtBirthDate.sendKeys(inputData.get("petbirth"));
        drdType.click();
        Select select = new Select(drdType);
        select.selectByValue(inputData.get("pettype"));
    }

    public Map<String, String> readPetDetails() throws Exception{
        Map<String, String> tableData = new HashMap<>();
        tableData.put("petname", petDetails.get(0).getText());
        tableData.put("petbirth", petDetails.get(1).getText());
        tableData.put("pettype", petDetails.get(2).getText());
        return tableData;
    }
}
