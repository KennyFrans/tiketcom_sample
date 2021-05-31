package com.tiket.stepDefinitions;

import com.tiket.context.TestContext;
import com.tiket.pages.TiketFlightDetailsPage;
import com.tiket.pages.TiketOrderPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class TiketOrderSteps {

    TiketOrderPage tiketOrderPage;
    TestContext testContext;

    public TiketOrderSteps(TestContext context) {
        testContext = context;
        tiketOrderPage = testContext.getPageObjectManager().getTiketOrderPage();
    }

    @Then("^The url should be find order page \"([^\"]*)\"$")
    public void theUrlShouldBeFindFlightPage(String url) throws Throwable {
        Thread.sleep(4000);
        Assert.assertTrue(tiketOrderPage.getPageUrl().contains(url));
    }

    @And("^User choose payment type \"([^\"]*)\" using \"([^\"]*)\"$")
    public void userChoosePaymentTypeUsing(String paymentType, String vendor) throws Throwable {
        tiketOrderPage.selectPayment(paymentType,vendor);
    }

    @When("^Click proceed payment$")
    public void clickProceedPayment() {
        tiketOrderPage.clickProceed();
    }

    @Then("^User should successfully create transaction and logout$")
    public void userShouldSuccessfullyCreateTransaction() throws InterruptedException {
        Assert.assertTrue(tiketOrderPage.isTransactionCreated());
        Thread.sleep(2000);
        tiketOrderPage.logout();
        Thread.sleep(3000);
    }
}
