package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test_1_Select_Country_Language {
    //1º Variables
    private WebDriver driver;
    SelectCountryAndLanguage selectCountryAndLanguage;
    //2º Methods
    @BeforeEach
    public void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        selectCountryAndLanguage = new SelectCountryAndLanguage(driver);
    }

    @AfterEach
    public void closeDriver(){
        System.out.println("Cerramos el driver");
        driver.quit();
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test 1 : Selecciona país/idioma y encuentra el logo de BERSHKA")

    public void test_1_LanguageAndGo() throws InterruptedException {

        try{
            SelectCountryAndLanguage.selectCountryAndLanguage();
        } catch (AssertionError | Exception e) {
            e.printStackTrace();
            System.exit(-1);
            throw e;
        }

    }
}