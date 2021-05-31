package com.tiket.stepDefinitions;

import com.tiket.context.TestContext;
import com.tiket.pages.TiketHotelDetailsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class TiketHotelDetailsStep {
    TiketHotelDetailsPage tiketRoomDetailsPage;
    TestContext testContext;

    public TiketHotelDetailsStep(TestContext context) {
        testContext = context;
        tiketRoomDetailsPage = testContext.getPageObjectManager().getRoomDetailsPage();
    }

    @Then("^The url should be checkout hotel order page \"([^\"]*)\"$")
    public void theUrlShouldBeFindRoomPage(String url) throws Throwable {
        Assert.assertTrue(tiketRoomDetailsPage.getPageUrl().contains(url));
    }

    @And("^User fill hotel order detail and click proceed$")
    public void userFillHotelOrderDetail() throws InterruptedException {
        tiketRoomDetailsPage.fillForms();
    }
}
