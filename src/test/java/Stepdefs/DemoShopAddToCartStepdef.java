package Stepdefs;

import Managers.PageObjectManager;
import Managers.WebDriverManager;
import Utilities.PropertiesFileReader;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import pageObjects.DemoShopPage;

import java.util.concurrent.TimeUnit;

public class DemoShopAddToCartStepdef {
    PropertiesFileReader fileReader;
    public static WebDriver driver;
    WebDriverManager webDriverManager;
    PageObjectManager pageObjectManager;
    DemoShopPage demoShopLandingPage;

    @Given("^User launches browser and launches app$")
    public void launchBrowserAndApp() throws Exception{
        fileReader = new PropertiesFileReader();
        System.out.println("Driver path :: "+fileReader.getDriverPath());
        webDriverManager = new WebDriverManager();
        driver = webDriverManager.getDriver();
        pageObjectManager=new PageObjectManager(driver);
//        System.setProperty("webdriver.chrome.driver",fileReader.getDriverPath());
//        driver = new ChromeDriver();
        ///System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + File.separator +"drivers"+File.separator+"chromedriver"+File.separator+"chromedriver.exe");
        ////driver = new ChromeDriver();
        driver.get(fileReader.getBrowserUrl());
        System.out.println("The url is "+fileReader.getBrowserUrl());
        driver.manage().timeouts().implicitlyWait(fileReader.getImplicitlyWait(), TimeUnit.SECONDS);
        ///driver.manage().window().maximize();
        fileReader.getBrowserWindowSize();
        Thread.sleep(10000);
    }
}
