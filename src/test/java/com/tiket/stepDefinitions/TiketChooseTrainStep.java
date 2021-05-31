package com.tiket.stepDefinitions;

import com.tiket.context.TestContext;
import com.tiket.pages.TiketChooseFlightPage;
import com.tiket.pages.TiketChooseTrainPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class TiketChooseTrainStep {
    TiketChooseTrainPage tiketChooseTrainPage;
    TestContext testContext;

    public TiketChooseTrainStep(TestContext context) {
        testContext = context;
        tiketChooseTrainPage = testContext.getPageObjectManager().getTiketChooseTrainPage();
    }


    @Then("^The url should be find train page \"([^\"]*)\" and available trains$")
    public void theUrlShouldBeFindFlightPage(String url) throws Throwable {
        Assert.assertTrue(tiketChooseTrainPage.getPageUrl().contains(url));
    }

    @When("^User choose train and click ok$")
    public void userChooseTrain() {
        tiketChooseTrainPage.chooseTrain();
    }
}
