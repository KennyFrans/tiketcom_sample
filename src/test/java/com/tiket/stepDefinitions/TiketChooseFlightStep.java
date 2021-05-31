package com.tiket.stepDefinitions;

import com.tiket.context.TestContext;
import com.tiket.pages.TiketChooseFlightPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;


public class TiketChooseFlightStep {

    TiketChooseFlightPage tiketChooseFlightPage;
    TestContext testContext;

    public TiketChooseFlightStep(TestContext context) {
        testContext = context;
        tiketChooseFlightPage = testContext.getPageObjectManager().getChooseFlightPage();
    }


    @Then("^The url should be find flight page \"([^\"]*)\"$")
    public void theUrlShouldBeFindFlightPage(String url) throws Throwable {
        Assert.assertTrue(tiketChooseFlightPage.getPageUrl().contains(url));
    }

    @And("^User choose \"([^\"]*)\" transit$")
    public void userChooseTransit(String transit) throws InterruptedException {
        tiketChooseFlightPage.chooseTransitType(transit);
    }

    @And("^User choose \"([^\"]*)\" as departure time$")
    public void userChooseAsDepartureTime(String time) throws Throwable {
        tiketChooseFlightPage.chooseDepartureTime(time);
    }

    @And("^User choose \"([^\"]*)\" as arrival time$")
    public void userChooseAsArrivalTime(String time) throws Throwable {
        tiketChooseFlightPage.chooseArrivalTime(time);
    }

    @And("^User choose departure plane$")
    public void userChooseLionAirForDeparturePlane() throws InterruptedException {
//        tiketChooseFlightPage.chooseLionAir();
        tiketChooseFlightPage.selectDepartureFlight();
    }

    @When("^User choose arrival plane$")
    public void userChooseLionAirForArrivalPlane() throws InterruptedException {
//        tiketChooseFlightPage.chooseLionAir();
        tiketChooseFlightPage.selectReturnFlight();
    }
}
