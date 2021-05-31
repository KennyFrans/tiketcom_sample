package com.tiketcom.steps;

import com.tiketcom.dataproviders.ConfigFileReaders;
import com.tiketcom.managers.PageObjectManager;
import com.tiketcom.pages.TiketHomePage;
import com.tiketcom.pages.TiketLoginPage;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Steps {
    WebDriver driver;
    TiketHomePage tiketHomePage;
    TiketLoginPage tiketLoginPage;
    ConfigFileReaders configFileReader;
    PageObjectManager pageObjectManager;


    @Given("^user is on Home Page$")
    public void user_is_on_Home_Page(){
        configFileReader= new ConfigFileReaders();
        System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
        pageObjectManager = new PageObjectManager(driver);
        tiketHomePage = pageObjectManager.getHomePage();
        tiketHomePage.navigateToTiketHomePage();
    }
}
