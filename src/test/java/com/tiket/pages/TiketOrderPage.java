package com.tiket.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TiketOrderPage extends BasePage {
    public TiketOrderPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(how = How.CSS, using = "div.payment-methods-list")
    private List<WebElement> paymentList;

    @FindBy(how = How.CSS, using = "div.payment-button-next-step > button")
    private WebElement btnNext;

//    div.payment-button-next-step > button

    public void selectPayment(String paymentType, String paymentVendor){
        WebDriverWait wait = new WebDriverWait(driver, 10);

        List<WebElement> paymentTypeMethods = null;
        for(WebElement payment: paymentList){
            String typePayment = payment.findElement(By.cssSelector("div > h3")).getAttribute("innerHTML");
            if (typePayment.equalsIgnoreCase(paymentType)){
                paymentTypeMethods = payment.findElements(By.cssSelector("div > a"));
                break;
            }
        }

        if (paymentTypeMethods != null){
            for (WebElement method : paymentTypeMethods){
                if(method.findElement(By.cssSelector("div.payment-method-item > div > span")).getAttribute("innerHTML").equalsIgnoreCase(paymentVendor)){
                    wait.until(ExpectedConditions.elementToBeClickable(method));
                    method.click();
                    break;
                }
            }
        }

    }

    public void clickProceed(){
        wait.until(ExpectedConditions.elementToBeClickable(btnNext));
        btnNext.click();
    }

    public boolean isTransactionCreated(){
        wait.until(x->x.findElement(By.cssSelector("div.total-payment")));
        return driver.findElements(By.cssSelector("div.total-payment")).size() != 0;
    }
}
