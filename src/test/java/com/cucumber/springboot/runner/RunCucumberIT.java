package com.cucumber.springboot.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.cucumber.springboot",
        publish = true
        ,tags = "@Test1"
)
public class RunCucumberIT {
}
