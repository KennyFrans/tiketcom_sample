package com.tiket.stepDefinitions;

import com.tiket.context.TestContext;
import com.tiket.pages.TiketLoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class TiketLoginPageStep {

    TiketLoginPage tiketLoginPage;
    TestContext testContext;


    public TiketLoginPageStep(TestContext context) {
        testContext = context;
        tiketLoginPage = testContext.getPageObjectManager().getLoginPage();
    }



    @Then("^The url should be user login page \"([^\"]*)\"$")
    public void theUrlShouldBeUserLoginPage(String url) throws Throwable {
        Assert.assertTrue(tiketLoginPage.getPageUrl().contains(url));
    }


    @When("^User try to login with email \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void userTryToLoginWithEmailAndPassword(String email, String password) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
       tiketLoginPage.doLogin(email,password);
    }


    @When("^User try to login using facebok with email \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void userTryToLoginUsingFacebokWithEmailAndPassword(String email, String password) throws Throwable {
        tiketLoginPage.loginUsingFacebook(email,password);
    }
}
