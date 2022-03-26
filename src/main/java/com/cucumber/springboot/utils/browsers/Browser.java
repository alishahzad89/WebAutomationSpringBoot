package com.cucumber.springboot.utils.browsers;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;


public interface Browser {
    RemoteWebDriver execute(String environment) throws MalformedURLException;
}
