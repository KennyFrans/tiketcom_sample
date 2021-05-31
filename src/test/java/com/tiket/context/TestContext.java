package com.tiket.context;

import com.tiket.dataproviders.ConfigFileReaders;
import com.tiket.managers.PageObjectManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestContext {
    private final PageObjectManager pageObjectManager;
    ConfigFileReaders configFileReader;
    public WebDriver driver;
    public ScenarioContext scenarioContext;

    public TestContext(){

        configFileReader= new ConfigFileReaders();
        System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);

        pageObjectManager = new PageObjectManager(this.driver);
        scenarioContext = new ScenarioContext();
    }


    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }

    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }
}
