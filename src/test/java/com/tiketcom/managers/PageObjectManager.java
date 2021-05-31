package com.tiketcom.managers;

import com.tiketcom.pages.TiketHomePage;
import com.tiketcom.pages.TiketLoginPage;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    private WebDriver driver;

    private TiketHomePage homePage;
    private TiketLoginPage loginPage;


    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public TiketHomePage getHomePage(){
        return (homePage  == null) ? homePage  = new TiketHomePage(driver) : homePage;
    }

    public TiketLoginPage getLoginPage(){
        return (loginPage  == null) ? loginPage  = new TiketLoginPage(driver) : loginPage;
    }
}
