package com.tiket.stepDefinitions;

import com.tiket.context.TestContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
    TestContext testContext;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @Before
    public void BeforeSteps() {
    }

    @After
    public void AfterSteps() throws InterruptedException {
        Thread.sleep(5000);
        testContext.driver.quit();
    }
}
