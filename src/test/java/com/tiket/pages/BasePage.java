package com.tiket.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    Faker faker;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.faker = new Faker();
        this.js = ((JavascriptExecutor) driver);
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public boolean elementExists(By locator)
    {
        return driver.findElements(locator).size() > 0;
    }

    public void isAlertPresent(WebDriver driver) {
        try
        {
            driver.switchTo().alert();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  // even though not needed

            isAlertPresent(driver);
        }   // try
        catch (NoAlertPresentException ignored)
        {

        }
    }

    public String getOTP(){
        js.executeScript("window.promptResponse=prompt('Please enter the OTP that has been sent to your mobile')");
        isAlertPresent(driver);
        return (String) js.executeScript("return window.promptResponse");
    }

    public String getPageUrl() throws InterruptedException {
        Thread.sleep(1500);
        return driver.getCurrentUrl();
    }

    public void logout(){
        driver.navigate().to("https://www.tiket.com/logout");
    }

    public WebElement FindElementWaitUntil(By by, int timeoutInSeconds){
        if (timeoutInSeconds > 0){
            WebDriverWait wait = new WebDriverWait(driver,TimeUnit.SECONDS.toSeconds(timeoutInSeconds));
            return wait.until(x -> x.findElement(by));
        }
        return driver.findElement(by);
    }

    public boolean isAttribtuePresent(WebElement element, String attribute) {
        Boolean result = false;
        try {
            String value = element.getAttribute(attribute);
            if (value != null){
                result = true;
            }
        } catch (Exception e) {}

        return result;
    }

    public ExpectedDate dateHelper(String date) throws ParseException {
        Locale INDONESIA = new Locale("in", "ID");
        DateFormat format = new SimpleDateFormat("d MMMM yyyy", INDONESIA);
        Date d = format.parse(date);
        Calendar myCal = new GregorianCalendar();
        myCal.setTime(d);

        int day = myCal.get(Calendar.DAY_OF_MONTH);
        String monthName = myCal.getDisplayName(Calendar.MONTH, Calendar.LONG, INDONESIA);
        int year = myCal.get(Calendar.YEAR);


        String expectedDate = monthName + ' ' + year;
        ExpectedDate ed = new ExpectedDate();
        ed.fullDate = expectedDate;
        ed.day = day;
        ed.year = year;
        ed.month = monthName;

       return ed;
    }

    public static class ExpectedDate{
        public String fullDate;
        public int day;
        public String month;
        public int year;
    }
}


