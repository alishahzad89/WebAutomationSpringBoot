package com.cucumber.springboot.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class VeterinPages {

    @FindBy(xpath = "//div[@class='container xd-container']/h2")
    public WebElement vetHeader;

    @FindBy(xpath = "//table[@class='table table-striped']/tbody")
    public WebElement vetTable;

    public String btnNext ="//a[@class='fa fa-step-forward']";
}
