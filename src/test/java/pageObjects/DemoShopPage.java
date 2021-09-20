package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DemoShopPage {
    WebDriver driver;
    /////constructor
    public DemoShopPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.XPATH,using="//input[@placeholder='Search products...']")
    private WebElement txtbx_SearchField;
}
