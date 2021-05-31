package com.tiket.stepDefinitions;

import com.tiket.context.TestContext;
import com.tiket.pages.TiketChooseHotelPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class TiketChooseHotelStep {

    TiketChooseHotelPage tiketChooseRoomPage;
    TestContext testContext;

    public TiketChooseHotelStep(TestContext context) {
        testContext = context;
        tiketChooseRoomPage = testContext.getPageObjectManager().getChooseRoomPage();
    }

    @Then("^The url should be find hotel page \"([^\"]*)\" and rooms are available$")
    public void theUrlShouldBeFindRoomPage(String url) throws Throwable {
        Assert.assertTrue(tiketChooseRoomPage.getPageUrl().contains(url));
        Assert.assertTrue(tiketChooseRoomPage.roomIsAvailable());
    }

    @When("^User select some room$")
    public void userSelectSomeRoom() throws InterruptedException {
        tiketChooseRoomPage.selectRoom();
    }
}
