package com.tiket.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/functionalTests/TiketPlaneTest.feature",
        glue = "com.tiket.stepDefinitions"
)
public class TestPlaneRunner {
}
