package com.tiket.stepDefinitions;

import com.tiket.context.Context;
import com.tiket.context.TestContext;
import com.tiket.pages.TiketHomePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class TiketHomePageStep {
    TiketHomePage tiketHomePage;
    TestContext testContext;


    public TiketHomePageStep(TestContext context) {
        testContext = context;
        tiketHomePage = testContext.getPageObjectManager().getHomePage();
    }

    @Given("^User is at home page$")
    public void userIsAtHomePage() throws InterruptedException {
        tiketHomePage.navigateToTiketHomePage();
    }

    @And("^User choose plane service$")
    public void userChoosePlaneService() throws InterruptedException {
        tiketHomePage.choosePlaneService();
    }

    @And("^User set flight departure date \"([^\"]*)\"$")
    public void userSetFlightDate(String date) throws Throwable {
//       tiketHomePage.setDate(date);
       tiketHomePage.setCommonDate(date);
    }

    @And("^User set flight return date \"([^\"]*)\"$")
    public void userSetFlightReturnDate(String date) throws Throwable {
//        tiketHomePage.setDate(date);
        tiketHomePage.setCommonDate(date);
    }

    @And("^User choose done$")
    public void userChooseDone() throws InterruptedException {
        tiketHomePage.chooseDone();
    }

    @And("^User set from \"([^\"]*)\"$")
    public void userSetFrom(String from) throws Throwable {
        tiketHomePage.setFrom(from);
    }

    @And("^User set destination to \"([^\"]*)\"$")
    public void userSetDestinationTo(String dest) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
       tiketHomePage.setDestination(dest);
    }

    @When("^User click Find flight$")
    public void userClickFindFlight() throws Throwable {
        tiketHomePage.clickFindFlight();
    }

    @Given("^user at kereta home page$")
    public void userAtKeretaHomePage() throws InterruptedException {
        tiketHomePage.navigateToTrainHomePage();
    }

    @And("^user choose \"([^\"]*)\" as From station$")
    public void userChooseAsFromStation(String from) throws Throwable {

       tiketHomePage.setKeretaFrom(from);
    }

    @And("^User set train departure date \"([^\"]*)\"$")
    public void userSetTrainDepartureDate(String date) throws Throwable {

        tiketHomePage.setDateForKereta(date);
    }

    @And("^user choose \"([^\"]*)\" as Destination station$")
    public void userChooseAsDestinationStation(String to) throws Throwable {
        tiketHomePage.setKeretaTo(to);
    }

    @And("^User set (\\d+) adults and (\\d+) infant$")
    public void userSetAdultsAndInfant(int adult, int infant) throws InterruptedException {
        testContext.scenarioContext.setContext(Context.INFANT,infant);
        testContext.scenarioContext.setContext(Context.ADULT,adult);

        tiketHomePage.setMatureAndInfantQuota(adult,infant);
    }

    @When("^User click search train$")
    public void userClickSearchTrain() throws InterruptedException {
        tiketHomePage.clickFindTrain();
    }


    @And("^user click login$")
    public void userClickLogin() {
        tiketHomePage.clickLogin();
    }

    @Then("^user should login successfully$")
    public void userShouldLoginSuccessfully() {
        Assert.assertTrue(tiketHomePage.isUserLoggedIn());
    }

    @And("^user choose \"([^\"]*)\" for hotel$")
    public void userChooseForHotel(String location) throws Throwable {
        tiketHomePage.selectDestination(location);
    }

    @And("^User set check-in date \"([^\"]*)\"$")
    public void userSetCheckInDate(String date) throws Throwable {
        tiketHomePage.setCommonDate(date);
    }

    @And("^User set check-out date \"([^\"]*)\"$")
    public void userSetCheckOutDate(String date) throws Throwable {
        tiketHomePage.setCommonDate(date);
    }

    @And("^User rent for (\\d+) person and rent (\\d+) room$")
    public void userSetPersonAndRentRoom(int room, int person) throws InterruptedException {
        testContext.scenarioContext.setContext(Context.ROOM,room);
        testContext.scenarioContext.setContext(Context.PERSON,person);
        tiketHomePage.setPersonAndRoom(room,person);
    }

    @When("^User click find hotel$")
    public void userClickFindHotel() throws InterruptedException {
        tiketHomePage.userClickFindHotel();
    }
}