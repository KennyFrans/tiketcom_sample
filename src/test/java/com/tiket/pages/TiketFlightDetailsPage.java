package com.tiket.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class TiketFlightDetailsPage extends BasePage {

    public TiketFlightDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.CSS, using = ".login-bar-wrapper > .list-horizontal__middle:nth-child(2) > div > button:nth-child(2)")
    private WebElement loginButton;

    @FindBy(how = How.CSS, using = "div.heading-passenger-details > label.label-left")
    private WebElement toogleSameAsContactPerson;

    @FindBy(how = How.CSS, using = "div.form > div:last-child > button")
    private WebElement btnProceedToPayment;

    @FindBy(how = How.CSS, using = "div.btn-notif > button:last-child")
    private WebElement btnModalContinueToPayment;

    @FindBy(how = How.CSS, using = "div.contact-name > div:nth-child(1) > div > div.title-flight-dropdown")
    private WebElement ddlTitleContactDetail;

    @FindBy(how = How.CSS, using = "div.contact-name > div:nth-child(2) > div > input")
    private WebElement inputNameContactDetail;

    @FindBy(how = How.CSS, using = "input[name='cp-email']")
    private WebElement inputEmailContactDetail;

    @FindBy(how = How.CSS, using = "input[name='cp-phone']")
    private WebElement inputPhoneNumberContactDetail;

    @FindBy(how = How.CSS, using = "div.tix-core-country-dropdown")
    private WebElement ddlNationality;


    @FindBy(how = How.CSS, using = "div.with-popup-content")
    private WebElement modalSameTransaction;


//    div.body-passenger-details > row:last-child

//
//    div.tix-core-country-dropdown >div  > div.box-with-search
//    div.box-with-search > div.filter > input
//    div.list-menu > ul > li
//    div.list-menu > ul > li > div:last-child

    public void doFillOrderDetail() throws InterruptedException {
        selectTitle();

        Thread.sleep(1500);
        inputNameContactDetail.sendKeys("Frans");

        Thread.sleep(1500);
        inputEmailContactDetail.sendKeys("frans@dummy.com");

        Thread.sleep(1500);
        inputPhoneNumberContactDetail.sendKeys("81219464232");

        selectNationality();
    }

    public void selectTitle() throws InterruptedException {
        Thread.sleep(1500);
        ddlTitleContactDetail.click();
        List<WebElement> titles = driver.findElements(By.cssSelector("div.flight-dropdown > div:last-child > ul > li"));

        for(WebElement title:titles){
            if(title.findElement(By.cssSelector("div")).getAttribute("innerHTML").equalsIgnoreCase("tuan")){
                Thread.sleep(1000);
                title.click();
            }
        }
    }

    public void selectNationality() throws InterruptedException {
        if (!driver.findElements(By.cssSelector("div.tix-core-country-dropdown")).isEmpty()){

            Thread.sleep(1500);
            ddlNationality.click();

            WebElement inputNationality = ddlNationality.findElement(By.cssSelector("div > div.box-with-search > div.filter > input"));
            if (inputNationality.isDisplayed()){
                inputNationality.sendKeys("indonesia");
                Thread.sleep(1500);
                List<WebElement> listCountry = driver.findElements(By.cssSelector("div.list-menu > ul > li"));
                for(WebElement country : listCountry){
                    if(country.findElement(By.cssSelector("div")).getAttribute("innerHTML").equalsIgnoreCase("indonesia")){
                        Thread.sleep(1000);
                        country.click();
                    }
                }
            }
        }

    }

    public void clickLogin() throws InterruptedException {
        Thread.sleep(2000);
        loginButton.click();
    }

    public void toggleSameAsContact() throws InterruptedException {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(toogleSameAsContactPerson));
        toogleSameAsContactPerson.click();
        selectNationality();
    }

    public boolean userIsLoggedIn() throws InterruptedException {
        Thread.sleep(1500);
        return loginButton.isDisplayed();
    }

    public void proceedPaymentClick() throws InterruptedException {
        Thread.sleep(1000);
        btnProceedToPayment.click();

        Thread.sleep(1500);
        if(btnModalContinueToPayment.isDisplayed()){
            btnModalContinueToPayment.click();
        }

        if(!driver.findElements(By.cssSelector("div.content-notification")).isEmpty()){
            WebElement btnProceed = modalSameTransaction.findElement(By.cssSelector("div > div.btn-notif > button"));
            Thread.sleep(1500);
            btnProceed.click();

        }

    }
}
