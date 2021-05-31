package com.tiket.managers;

import com.tiket.pages.*;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    private WebDriver driver;

    private TiketHomePage homePage;
    private TiketLoginPage loginPage;
    private TiketChooseFlightPage chooseFlightPage;
    private TiketFlightDetailsPage tiketFlightDetailsPage;
    private TiketOrderPage tiketOrderPage;

    private TiketChooseTrainPage tiketChooseTrainPage;

    private TiketChooseHotelPage chooseRoomPage;
    private TiketHotelDetailsPage roomDetailsPage;



    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public TiketHomePage getHomePage(){
        return (homePage  == null) ? homePage  = new TiketHomePage(driver) : homePage;
    }

    public TiketLoginPage getLoginPage(){
        return (loginPage  == null) ? loginPage  = new TiketLoginPage(driver) : loginPage;
    }

    public TiketChooseFlightPage getChooseFlightPage(){
        return (chooseFlightPage  == null) ? chooseFlightPage  = new TiketChooseFlightPage(driver) : chooseFlightPage;
    }

    public TiketFlightDetailsPage getDetailsFlightPage(){
        return (tiketFlightDetailsPage  == null) ? tiketFlightDetailsPage  = new TiketFlightDetailsPage(driver) : tiketFlightDetailsPage;
    }

    public TiketOrderPage getTiketOrderPage(){
        return (tiketOrderPage  == null) ? tiketOrderPage  = new TiketOrderPage(driver) : tiketOrderPage;
    }

    public TiketChooseTrainPage getTiketChooseTrainPage(){
        return (tiketChooseTrainPage  == null) ? tiketChooseTrainPage  = new TiketChooseTrainPage(driver) : tiketChooseTrainPage;
    }

    public TiketChooseHotelPage getChooseRoomPage(){
        return (chooseRoomPage  == null) ? chooseRoomPage  = new TiketChooseHotelPage(driver) : chooseRoomPage;
    }
    public TiketHotelDetailsPage getRoomDetailsPage(){
        return (roomDetailsPage  == null) ? roomDetailsPage  = new TiketHotelDetailsPage(driver) : roomDetailsPage;
    }


}

