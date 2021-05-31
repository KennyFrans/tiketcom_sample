package com.tiketcom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TiketHomePage {

    WebDriver driver;
    public TiketHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//a[contains(.,'Login')]")
    private WebElement btnLogin;

    public void navigateToTiketHomePage(){
        driver.get("https://www.tiket.com/");
    }

    public void doLogin(){
        btnLogin.click();
    }
}
