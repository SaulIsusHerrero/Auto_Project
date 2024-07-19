package test;

import Step.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class MyFirstTest  {
    //1º Variables
    private WebDriver driver;
    Step step;


    //2º Methods
    @BeforeEach
    public void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        step = new Step(driver);
    }

    @AfterEach
    public void closeDriver(){
        System.out.println("Cerramos el driver");
        driver.quit();
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test 1 : Selecciona país/idioma y encuentra el logo de BERSHKA")
    public void test_1_my_fist_test()  {

        try{
        step.goTo();
        step.manageCookies();
        step.manageCountryAndLanguage();
        step.selectWomanProducts();
        } catch (AssertionError | Exception e) {
            e.printStackTrace();
            System.exit(-1);
            throw e;
        }

    }
}

