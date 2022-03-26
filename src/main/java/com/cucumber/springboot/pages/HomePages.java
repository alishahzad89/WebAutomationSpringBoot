package com.cucumber.springboot.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class HomePages {

    @FindBy(xpath = "//ul//span[@class='fa fa-home']")
    public WebElement btnHome;

    @FindBy(xpath = "//ul//span[@class='fa fa-search']")
    public WebElement btnFindOwner;

    @FindBy(xpath = "//span[@class='fa fa-th-list']")
    public WebElement btnFindVeterin;

    @FindBy(xpath = "//img[@class='img-responsive']")
    public WebElement homeLogo;
}
