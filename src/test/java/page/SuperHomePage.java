package page;

import org.example.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SuperHomePage extends Base {
    //1º Declare variables
    protected static WebDriver driver;

    //2º Locators
    static By womanLink = By.xpath("//div[@class='gender-selector super-home-gender-selector__menu']/div/div[1]/a");

    //3º Constructor
    public SuperHomePage(WebDriver driver) {
        super(driver);
        CookiesPage.driver = driver;
    }

    public void clickWomanButton(){
        clickAndWait(womanLink);
    }

}
