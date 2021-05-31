package com.tiket.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class TiketHotelDetailsPage extends BasePage {


    public TiketHotelDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.CSS, using = "div.card:nth-child(3) > form")
    private List<WebElement> personRoomForms;

    @FindBy(how = How.CSS, using = "div.card:nth-child(2) > form")
    private WebElement personHeadForm;

    @FindBy(how = How.CSS, using = "div.card:nth-child(3)")
    private WebElement formHook;


    public void fillForms() throws InterruptedException {

        checkHeadTitle();

        js.executeScript("arguments[0].scrollIntoView(true);", formHook);

        for (int i = 0; i < personRoomForms.size(); i++) {
            if (i!=0){
                WebElement personForm = personRoomForms.get(i);
                selectTitle(personForm,"tuan");
                setName(personForm,faker.name().firstName());
            }
        }


        driver.findElement(By.cssSelector("div.booking-submit > button")).click();
    }

    private void checkHeadTitle() throws InterruptedException {

        WebElement input = personHeadForm.findElement(By.cssSelector("div.title-field > div > div.text-input > input"));
        if (input.getAttribute("value").isEmpty()){
            selectTitle(personHeadForm,"tuan");
        }
    }

    private void selectTitle(WebElement form, String t) throws InterruptedException {
        Thread.sleep(2000);
        WebElement titleOption =  form.findElement(By.cssSelector("div.title-field"));
        titleOption.click();
        List<WebElement> listTitle = titleOption.findElements(By.cssSelector("div.tix-pop-over > div > div.radio-list > div > div:first-child"));
        for(WebElement title : listTitle){
            if (title.getAttribute("innerHTML").equalsIgnoreCase(t)){
                Thread.sleep(1500);
                title.click();
                break;
            }
        }
    }

    private void setName(WebElement form, String name){
        WebElement inputName  =  form.findElement(By.cssSelector("div.name-field > div > div.text-input > input"));
        wait.until(ExpectedConditions.elementToBeClickable(inputName));
        inputName.sendKeys(name);
    }


//    div.card:nth-child(3) > form > div.title-field
//    div.tix-pop-over > div > div.radio-list > div > div:first-child

//    div.card:nth-child(3) > form > div.name-field > div > div.text-input > input


}
