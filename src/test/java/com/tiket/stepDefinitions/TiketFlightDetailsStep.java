package com.tiket.stepDefinitions;

import com.tiket.context.TestContext;
import com.tiket.pages.TiketFlightDetailsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Th;
import org.junit.Assert;

public class TiketFlightDetailsStep {
    TiketFlightDetailsPage tiketFlightDetailsPage;
    TestContext testContext;

    public TiketFlightDetailsStep(TestContext context) {
        testContext = context;
        tiketFlightDetailsPage = testContext.getPageObjectManager().getDetailsFlightPage();
    }

    @Then("^The url should be flight details page \"([^\"]*)\"$")
    public void theUrlShouldBeFindFlightPage(String url) throws Throwable {
        Assert.assertTrue(tiketFlightDetailsPage.getPageUrl().contains(url));
    }

    @And("^User click login using email$")
    public void userClickLoginUsingEmail() throws Throwable{
        tiketFlightDetailsPage.clickLogin();
    }

    @Then("^User should be able to login successfully$")
    public void userShouldBeAbleToLoginSuccessfully() throws InterruptedException {
        Assert.assertFalse(tiketFlightDetailsPage.userIsLoggedIn());
    }


    @And("^User toggle same as contact person for passenger details$")
    public void userToggleSameAsContactPersonForPassengerDetails() throws InterruptedException {
        tiketFlightDetailsPage.toggleSameAsContact();
    }

    @When("^User do proceed payment and wait proceeding$")
    public void userDoProceedPayment() throws InterruptedException {
        tiketFlightDetailsPage.proceedPaymentClick();

    }

    @And("^User fill order detail$")
    public void userFillOrderDetail() throws InterruptedException {
        tiketFlightDetailsPage.doFillOrderDetail();
    }
}
