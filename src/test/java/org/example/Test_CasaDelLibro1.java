package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test_CasaDelLibro1 {
    //1º Variables
    private WebDriver driver;
    TestsCasaDelLibro testsCasaDelLibro;
    //2º Methods
    @BeforeEach
    public void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-search-engine-choice-screen");
        driver = new ChromeDriver(chromeOptions);
        testsCasaDelLibro = new TestsCasaDelLibro(driver);
    }

    @AfterEach
    public void closeDriver(){
        System.out.println("Cerramos el driver");
        driver.quit();
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test 1 : Abrimos web, comprobamos y aceptamos Cookies")

    public void test_1_Cookies() throws InterruptedException {

        try{
            TestsCasaDelLibro.cookiesPageElements();
            TestsCasaDelLibro.acceptCookies();

            TestsCasaDelLibro.carritoPageDefaultElements();
            TestsCasaDelLibro.cerrarCarrito();
        } catch (AssertionError | Exception e) {
            e.printStackTrace();
            System.exit(-1);
            throw e;
        }

    }
}

