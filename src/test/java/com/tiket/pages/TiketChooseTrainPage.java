package com.tiket.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class TiketChooseTrainPage extends BasePage {
    public TiketChooseTrainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.CSS, using = "div.col-result > div:last-child >div:not([class='search-result login'])")
    public List<WebElement> trainResult;

//    div.train-list >div:last-child > div:last-child > button

    public void chooseTrain(){
        if (trainResult.size() != 0){
            WebElement result = trainResult.get(0);
            WebElement btnChoose = result.findElement(By.cssSelector("div.train-list >div:last-child > div:last-child > button"));
            if(!btnChoose.getAttribute("class").contains("disabled")){
                btnChoose.click();
            }
        }
    }

}
