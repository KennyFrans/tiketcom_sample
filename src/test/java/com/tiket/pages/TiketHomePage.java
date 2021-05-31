package com.tiket.pages;

import com.sun.deploy.util.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TiketHomePage extends BasePage {

    public TiketHomePage(WebDriver driver){
        super(driver);
    }


    @FindBy(how = How.XPATH, using = "//button[@class='ab-close-button']")
    private WebElement closeModal;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'CalendarMonthGrid_month__horizontal') and not(contains(@class,'CalendarMonthGrid_month__hidden'))]")
    private List<WebElement> commonReservationDate;
//    div[class*='CalendarMonthGrid_month__horizontal']:not([class*='CalendarMonthGrid_month__hidden'])

    @FindBy(how = How.CSS, using = "div[class*='CalendarMonthGrid_month__horizontal']:not([class*='CalendarMonthGrid_month__hidden'])")
    private List<WebElement> datePickers;

    @FindBy(how = How.XPATH, using = "//span[@class='product-label'][contains(.,'Pesawat')]")
    private WebElement btnServicePesawat;

    @FindBy(how = How.XPATH, using = "//input[contains(@id,'productSearchFrom')]")
    private WebElement inputFrom;

    @FindBy(how = How.XPATH, using = "//input[contains(@id,'productSearchTo')]")
    private WebElement inputTo;

    @FindBy(how = How.XPATH, using = "(//input[contains(@class,'input-airport ')])[1]")
    private WebElement inputKeretaFrom;

    @FindBy(how = How.XPATH, using = "(//input[contains(@class,'input-airport ')])[2]")
    private WebElement inputKeretaTo;

    @FindBy(how = How.XPATH, using = "(//i[@class='tix tix-chevron-right'])[2]")
    private WebElement btnFromNext;


    @FindBy(how = How.CSS, using = "div.passenger-cabin-drop-down-text > span")
    private WebElement btnDone;

    @FindBy(how = How.XPATH, using = "//button[@class='product-form-search-btn']")
    private WebElement findFLight;

    @FindBy(how = How.CSS, using = ".footer-part > button")
    private WebElement findTrain;

    @FindBy(how = How.CSS, using = "div.coach-mark > button")
    private WebElement btnNotifKeretaBandara;

    @FindBy(how = How.CSS, using = "div.station-list-box")
    private WebElement listStation;

    @FindBy(how = How.CSS, using = "div.passenger-box > div:first-child > div.right > div:last-child > button")
    private WebElement btnAdjustMature;

    @FindBy(how = How.CSS, using = "div.passenger-box > div:last-child > div.right > div:last-child > button")
    private WebElement btnAdjustInfant;

    @FindBy(how = How.CSS, using = "#productWidget")
    private WebElement widget;

    @FindBy(how = How.CSS, using = "div.train-form")
    private WebElement widgetTrain;

    @FindBy(how = How.CSS, using = ".product-form-search-btn")
    private WebElement btnFindHotel;

    @FindBy(how = How.CSS, using = ".header-right-side > a:nth-child(3)")
    private WebElement headerLogin;

    @FindBy(how = How.CSS, using = "div.header-account")
    private WebElement headerAccount;

    @FindBy(how = How.CSS, using = "#productSearchDestination")
    private WebElement searchHotelLocation;

    @FindBy(how = How.CSS, using = "div.passenger-cabin-item-list:nth-child(1) > div:last-child > div:first-child")
    private WebElement decreasePerson;
    @FindBy(how = How.CSS, using = "div.passenger-cabin-item-list:nth-child(1) > div:last-child > div:last-child")
    private WebElement increasePerson;
    @FindBy(how = How.CSS, using = "div.passenger-cabin-item-list:nth-child(1) > div:last-child > div.widget-passenger-counter")
    private WebElement personCounter;


    @FindBy(how = How.CSS, using = "div.passenger-cabin-item-list:nth-child(2) > div:last-child > div:first-child")
    private WebElement decreaseRoom;
    @FindBy(how = How.CSS, using = "div.passenger-cabin-item-list:nth-child(2) > div:last-child > div:last-child")
    private WebElement increaseRoom;
    @FindBy(how = How.CSS, using = "div.passenger-cabin-item-list:nth-child(2) > div:last-child > div.widget-passenger-counter")
    private WebElement roomCounter;



    public boolean isUserLoggedIn(){
        wait.until(ExpectedConditions.elementToBeClickable(headerAccount));
        if(elementExists(By.xpath("//button[@class='ab-close-button']"))){
            closeModal.click();
        }
        return headerAccount.isDisplayed();
    }

    public void selectDestination(String location) throws InterruptedException {
        List<String> items = Arrays.asList(location.split("\\s+"));
        js.executeScript("arguments[0].scrollIntoView(true);", widget);
        Thread.sleep(2000);

        wait.until(ExpectedConditions.elementToBeClickable(searchHotelLocation));
        for (String loc :items){
            searchHotelLocation.sendKeys(loc+" ");
            Thread.sleep(2000);
        }
        Thread.sleep(4000);
        searchHotelLocation.sendKeys(Keys.ENTER);
    }

    public void navigateToTiketHomePage() throws InterruptedException {
        driver.get("https://www.tiket.com/");
        Thread.sleep(1500);
        if(elementExists(By.xpath("//button[@class='ab-close-button']"))){
            closeModal.click();
        }
    }

    public void clickLogin(){
        headerLogin.click();
    }

    public void navigateToTrainHomePage() throws InterruptedException {
        driver.get("https://www.tiket.com/kereta-api");
        Thread.sleep(1500);
        if(btnNotifKeretaBandara.isDisplayed()){
            btnNotifKeretaBandara.click();
        }

        js.executeScript("arguments[0].scrollIntoView(true);", widgetTrain);
    }

    public void choosePlaneService() throws InterruptedException {
        btnServicePesawat.click();
        Thread.sleep(1500);
        js.executeScript("arguments[0].scrollIntoView(true);", widget);
    }

    public void clickFindFlight() throws InterruptedException {
        Thread.sleep(1500);
        findFLight.click();
    }

    public void setFrom(String from) throws InterruptedException {

        js.executeScript("arguments[0].scrollIntoView(true);", widget);
        Thread.sleep(2000);

        //choose from and fill jakarta
        inputFrom.click();
        Thread.sleep(1500);
        inputFrom.sendKeys(from);
        Thread.sleep(1500);
        inputFrom.sendKeys(Keys.ENTER);
    }

    public void setKeretaFrom(String from) throws InterruptedException {

        from = from.toLowerCase();
        inputKeretaFrom.click();
        Thread.sleep(1500);
        inputKeretaFrom.sendKeys(from);
        Thread.sleep(2000);

        if (listStation.isDisplayed()){
            List<WebElement> listOfCity = listStation.findElements(By.cssSelector("div.content > ul > li"));
            for (WebElement city:listOfCity) {
                if(city.getAttribute("data-stationname").toLowerCase().equals(from)){
                    Thread.sleep(1500);
                    city.click();
                    break;
                }

            }
        }
    }

    public void setMatureAndInfantQuota(int mature, int infant) throws InterruptedException {
        Thread.sleep(2000);
        for (int i = 0; i < mature; i++) {
            btnAdjustMature.click();
        }
        Thread.sleep(1500);
        for (int i = 0; i < infant; i++) {
            btnAdjustInfant.click();
        }

        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".foot > button")).click();
    }

    public void userClickFindHotel() throws InterruptedException {
        Thread.sleep(1500);
        btnFindHotel.click();
    }
    public void setPersonAndRoom(int person, int room) throws InterruptedException {
        Thread.sleep(2000);
        for (int i = 1; i < person; i++) {
            increasePerson.click();
        }
        Thread.sleep(1500);
        for (int i = 1; i < room; i++) {
            increaseRoom.click();
        }

        //person = 2
        //di display = 3
        while (Integer.parseInt(personCounter.getAttribute("innerHTML"))  > person){
            decreasePerson.click();
        }

        Thread.sleep(1000);
        btnDone.click();
    }

    public void clickFindTrain() throws InterruptedException {
        Thread.sleep(1000);
        findTrain.click();
    }

    public void setKeretaTo(String to) throws InterruptedException {

        to = to.toLowerCase();
        inputKeretaTo.click();
        Thread.sleep(1500);
        inputKeretaTo.sendKeys(to);
        Thread.sleep(2000);

        if (listStation.isDisplayed()){
            List<WebElement> listOfCity = listStation.findElements(By.cssSelector("div.content > ul > li"));
            for (WebElement city:listOfCity) {
                if(city.getAttribute("data-stationname").toLowerCase().equals(to)){
                    Thread.sleep(1500);
                    city.click();
                    break;
                }
            }
        }
    }

    public void setDestination(String destination) throws InterruptedException {
        //choose to and fill juanda
        inputTo.click();
        Thread.sleep(1500);
        inputTo.sendKeys(destination);
        Thread.sleep(1500);
        inputTo.sendKeys(Keys.ENTER);
    }

    public void chooseDone() throws InterruptedException {
        //presence in DOM
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.passenger-cabin-drop-down-text > span")));
        wait.until(ExpectedConditions.elementToBeClickable(btnDone));
        Thread.sleep(3000);
        js.executeScript("arguments[0].click();", btnDone);
//        btnDone.click();
    }

    public void setDate(String date) throws ParseException, InterruptedException {



        Thread.sleep(2500);

        //date processing
        ExpectedDate expectedDate = dateHelper(date);


        boolean ketemu = false;
        List<String> text = new ArrayList<>();

        Optional<WebElement> headerDate = Optional.empty();

        while(!ketemu){

            text.clear();
            for (WebElement el : commonReservationDate){
                List<WebElement> header = el.findElements(By.cssSelector("div.CalendarMonth > div.CalendarMonth_caption > strong"));
                headerDate = header.stream().filter(x->x.getAttribute("innerHTML").equals(expectedDate)).findAny();

                for (WebElement t :header){
                    text.add(t.getAttribute("innerHTML"));
                }

                if(headerDate.isPresent()) {
                    ketemu = true;
                }

            }

            if(!headerDate.isPresent()) {
                btnFromNext.click();
            }


        }

        Integer index = text.indexOf(headerDate.get().getText()) + 1;
        WebElement gridDate = driver.findElement(By.xpath(String.format("(//div[@class='CalendarMonthGrid_month__horizontal CalendarMonthGrid_month__horizontal_1'])[%d]",index)));
        List<WebElement> activeDates = gridDate.findElements(By.cssSelector(".CalendarMonth > table > tbody > tr > td.CalendarDay"));
        for (WebElement picketDate : activeDates){
            WebElement span = picketDate.findElement(By.cssSelector("div > span"));

            String selectedDay = span.getAttribute("innerHTML");
            if(selectedDay.equals(Integer.toString(expectedDate.day))){
                wait.until(ExpectedConditions.elementToBeClickable(span));


                JavascriptExecutor executor = (JavascriptExecutor)driver;
                executor.executeScript("arguments[0].click();", span);
//                span.click();
                break;
            }
        }
//        Thread.sleep(5000);
    }

    public void setDateForKereta(String date) throws ParseException, InterruptedException {

        Thread.sleep(5000);
        //date processing
        Locale INDONESIA = new Locale("in", "ID");
        DateFormat format = new SimpleDateFormat("d MMMM yyyy", INDONESIA);
        Date d = format.parse(date);
        Calendar myCal = new GregorianCalendar();
        myCal.setTime(d);

        Integer day = myCal.get(Calendar.DAY_OF_MONTH);
        String monthName = myCal.getDisplayName(Calendar.MONTH, Calendar.LONG, INDONESIA);
        Integer year = myCal.get(Calendar.YEAR);

        String expectedDate = monthName + ' ' + year;


        boolean ketemu = false;
        List<String> text = new ArrayList<>();
        Optional<WebElement> headerDate = Optional.empty();

        while(!ketemu){
            text.clear();
            for (WebElement el : commonReservationDate){
                List<WebElement> header = el.findElements(By.cssSelector(".CalendarMonth > .CalendarMonth_caption > strong"));
                headerDate = header.stream().filter(x->x.getAttribute("innerHTML").equals(expectedDate)).findAny();

                for (WebElement t :header){
                    text.add(t.getAttribute("innerHTML"));
                }

                if(headerDate.isPresent()) {
                    ketemu = true;
                }
            }

            if(!headerDate.isPresent()) {
                btnFromNext.click();
            }

        }

        Integer index = text.indexOf(headerDate.get().getText()) + 1;
        WebElement gridDate = driver.findElement(By.xpath(String.format("(//div[@class='CalendarMonthGrid_month__horizontal CalendarMonthGrid_month__horizontal_1'])[%d]",index)));
        List<WebElement> activeDates = gridDate.findElements(By.cssSelector(".CalendarMonth > table > tbody > tr > td.CalendarDay"));
        for (WebElement picketDate : activeDates){
            String selectedDay = picketDate.findElement(By.cssSelector("div")).getAttribute("innerHTML");
            if(selectedDay.equals(day.toString())){
                Thread.sleep(2000);
                picketDate.click();
                break;
            }
        }
//        Thread.sleep(5000);
    }

    public void setCommonDate(String date) throws InterruptedException, ParseException {
        Thread.sleep(1500);

        ExpectedDate expectedDate = dateHelper(date);
        WebElement resultOfMatchesDate = null;


        ////// Imagine like binary tree, the picker has 2 node right and left picker e.g (january | feb)
        // first i set the flag to indicate that the date belong to what month ? eg january or feb
        boolean dateFound = false;
        while (!dateFound){

            //traverse each node and get the calendar caption if the node find any with same caption people selected
            Optional<WebElement> datePicker = datePickers.stream()
                    .filter(x->
                            x.findElement(By.cssSelector("div.CalendarMonth > div.CalendarMonth_caption > strong"))
                                    .getAttribute("innerHTML")
                                    .equalsIgnoreCase(expectedDate.fullDate)
                    )
                    .findAny();


            if (datePicker.isPresent()){ //if the date found set datefond to true and get the element
                dateFound = true;
                resultOfMatchesDate = datePicker.get();
            }else{
                btnFromNext.click();
            }
        }

        List<WebElement> activeDates = resultOfMatchesDate.findElements(By.cssSelector(".CalendarMonth > table > tbody > tr > td.CalendarDay"));

        Optional<WebElement> selectedDate = activeDates.stream()
                .filter(x->
                        x.findElement(By.cssSelector("div > span"))
                                .getAttribute("innerHTML")
                                .equalsIgnoreCase(Integer.toString(expectedDate.day))
                )
                .findAny();

        if (selectedDate.isPresent()){
            wait.until(ExpectedConditions.elementToBeClickable(selectedDate.get()));
            selectedDate.get().click();
        }

    }

}
