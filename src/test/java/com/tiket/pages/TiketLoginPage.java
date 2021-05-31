package com.tiket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Set;

public class TiketLoginPage extends BasePage {

    public TiketLoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//ul[@class='btn-list']/li[3]")
    private WebElement btnLoginWithFacebook;

    @FindBy(how = How.XPATH, using = "//button[@name='__CONFIRM__']")
    private WebElement btnContinueLoginFacebook;

    @FindBy(how = How.CSS, using = "input[name='username']")
    private WebElement inputEmail;

    @FindBy(how = How.CSS, using = "button.submitEmail")
    private WebElement btnContinue;

    @FindBy(how = How.CSS, using = "input[name='password']")
    private WebElement inputPassword;

    @FindBy(how = How.CSS, using = "input[name='otp']")
    private WebElement inputOTP;

    @FindBy(how = How.CSS, using = "button.loginSubmitButton")
    private WebElement btnLogin;

    @FindBy(how = How.CSS, using = "input#email")
    private WebElement inputEmailFacebook;

    @FindBy(how = How.CSS, using = "input#pass")
    private WebElement inputPasswordFacebook;

    @FindBy(how = How.CSS, using = "input[type='submit']")
    private WebElement inputSubmitLogin;


    public void loginUsingFacebook(String email, String password) throws InterruptedException {
        btnLoginWithFacebook.click();

        String MainWindow=driver.getWindowHandle();
        Set<String> s1 = driver.getWindowHandles();

        for (String ChildWindow : s1) {
            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {



                // Switching to Child window
                driver.switchTo().window(ChildWindow);
                inputEmailFacebook.sendKeys(email);
                Thread.sleep(1500);
                inputPasswordFacebook.sendKeys(password);
                Thread.sleep(1500);

                inputSubmitLogin.click();

                // Closing the Child Window.
                driver.switchTo().window(MainWindow);
            }
        }
    }



    public void doLogin(String email, String password) throws InterruptedException {
        Thread.sleep(1500);
        inputEmail.sendKeys(email);

        Thread.sleep(1500);
        btnContinue.click();

        Thread.sleep(1500);
        inputPassword.sendKeys(password);

        Thread.sleep(1500);
        btnLogin.click();

        wait.until(ExpectedConditions.elementToBeClickable(inputOTP));
        String otp = getOTP();
        inputOTP.sendKeys(otp);


    }

}
