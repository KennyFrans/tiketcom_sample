package com.tiket.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;
import java.util.Random;

public class TiketChooseFlightPage extends BasePage{

    public TiketChooseFlightPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//div[@class='desc']/following-sibling::div")
    private WebElement btnMengertiorOk;

    @FindBy(how = How.XPATH, using = "//label[@for='direct']")
    private WebElement chkDirectTransit;

    @FindBy(how = How.XPATH, using = "//label[@for='stop']")
    private WebElement chkSingleTransit;

    @FindBy(how = How.XPATH, using = "//label[@for='stops']")
    private WebElement chkDoubleTransit;

    @FindBy(how = How.CSS, using = "input[name='airlines|JT'] + label")
    private WebElement chkAirlinesLionAir;

    @FindBy(how = How.CSS, using = "input[name='fare|tiketclean'] + label")
    private WebElement chkFareClean;

    @FindBy(how = How.CSS, using = "input[name='facilities|baggage'] + label")
    private WebElement chkFacilitiesBagage;

    @FindBy(how = How.XPATH, using = "(//div[@class='field'])[7]/div/div[2]/div/div[@class='custom-checkbox single']")
    private List<WebElement> chkAirPortTransit;

        @FindBy(how = How.CSS, using = ".wrapper-result > div > div > div:not([class='bg-new-login-bar'])")
    private List<WebElement> flightSearchResult;





    public void chooseLionAir() throws InterruptedException {

        chkAirlinesLionAir.click();

        Thread.sleep(2000);
    }

    public void chooseTransitType(String type) throws InterruptedException {
        btnMengertiorOk.click();



        switch (type.toLowerCase())
        {
            case "1":
                chkSingleTransit.click();
                break;
            case "2":
                chkDoubleTransit.click();
                break;
            case "direct":
                chkDirectTransit.click();
                break;
            default:
                break;
        }
        Thread.sleep(2000);

    }

    public void chooseDepartureTime(String time){
        time = time.toLowerCase();

        String selector = String.format("label[for='departure_%s']",time);
        WebElement labelDeparture = driver.findElement(By.cssSelector(selector));


        labelDeparture.click();

    }

    public void chooseArrivalTime(String time) throws InterruptedException {

        time = time.toLowerCase();

        String selector = String.format("label[for='arrival_%s']",time);
        WebElement labelDeparture = driver.findElement(By.cssSelector(selector));


        labelDeparture.click();

        Thread.sleep(2000);

    }

    public void setTransit() throws InterruptedException {
        WebElement firstElement = chkAirPortTransit.get(0);
        firstElement.click();

        Thread.sleep(2000);
    }

    public void selectDepartureFlight() throws InterruptedException {
        if(flightSearchResult.size() != 0){


            WebElement firstFlightElement = flightSearchResult.get(0);

            if(firstFlightElement.isDisplayed()){
                firstFlightElement.findElement(By.cssSelector(".btn-book-now")).click();
                Thread.sleep(5000);
            }
        }

    }

    public void selectReturnFlight() throws InterruptedException {

        if(flightSearchResult.size() != 0){
            WebElement firstFlightElement = flightSearchResult.get(0);

            if(firstFlightElement.isDisplayed()){
                firstFlightElement.findElement(By.cssSelector(".btn-book-now")).click();
                Thread.sleep(5000);
            }
        }
    }



}
