package com.tiketcom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


import java.util.Set;

public class TiketLoginPage {

    WebDriver driver;
    public TiketLoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//ul[@class='btn-list']/li[3]")
    private WebElement btnLoginWithFacebook;

    @FindBy(how = How.XPATH, using = "//button[@name='__CONFIRM__']")
    private WebElement btnContinueLoginFacebook;


    public void loginUsingFacebook(){
        btnLoginWithFacebook.click();

        String MainWindow=driver.getWindowHandle();
        Set<String> s1 = driver.getWindowHandles();

        for (String ChildWindow : s1) {
            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {

                // Switching to Child window
                driver.switchTo().window(ChildWindow);
                btnContinueLoginFacebook.click();

                // Closing the Child Window.
                driver.close();
            }
        }
    }
}
