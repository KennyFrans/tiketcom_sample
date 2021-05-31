package com.tiket.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/functionalTests/TiketHotelTest.feature",
        glue = "com.tiket.stepDefinitions"
)
public class TestHotelRunner {
}
