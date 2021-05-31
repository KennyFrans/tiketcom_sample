package com.tiket.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;

public class TiketChooseHotelPage extends BasePage {
    public TiketChooseHotelPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.CSS, using = "div.room-card-list > div.room-card")
    private List<WebElement> listRoom;


    public boolean roomIsAvailable(){
        return listRoom.size() != 0;
    }

    public void selectRoom() throws InterruptedException {
        WebElement widget = driver.findElement(By.cssSelector("div.widget-section"));
        js.executeScript("arguments[0].scrollIntoView(true);", widget);
        Thread.sleep(2000);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.room-card-list > div.room-card")));
        WebElement room = listRoom.get(0);
        WebElement btnSelectRoom = room.findElement(By.cssSelector("div.right-side > div.bottom-right > button"));
        wait.until(ExpectedConditions.elementToBeClickable(btnSelectRoom));
        btnSelectRoom.click();

    }
}
