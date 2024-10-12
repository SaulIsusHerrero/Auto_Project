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
            //TestsCasaDelLibro.catalogoPage();
            TestsCasaDelLibro.checkFiccion();
            //TestsCasaDelLibro.productoPage();
            TestsCasaDelLibro.checkProductoPage();
            TestsCasaDelLibro.addCarrito();
        } catch (AssertionError | Exception e) {
            e.printStackTrace();
            System.exit(-1);
            throw e;
        }

    }

    public void test_2_Ficcion() throws InterruptedException {

        try{
            TestsCasaDelLibro.cookiesPageElements();
            TestsCasaDelLibro.acceptCookies();
            //TestsCasaDelLibro.catalogoPage();
            TestsCasaDelLibro.checkFiccion();
        } catch (AssertionError | Exception e) {
            e.printStackTrace();
            System.exit(-1);
            throw e;
        }

    }

    public void test_3_Producto() throws InterruptedException {

        try{
            TestsCasaDelLibro.cookiesPageElements();
            TestsCasaDelLibro.acceptCookies();
            //TestsCasaDelLibro.catalogoPage();
            TestsCasaDelLibro.checkFiccion();
            //TestsCasaDelLibro.productoPage();
            TestsCasaDelLibro.checkProductoPage();
        } catch (AssertionError | Exception e) {
            e.printStackTrace();
            System.exit(-1);
            throw e;
        }

    }

    public void test_4_IsCartEmpty() throws InterruptedException {

        try{
            TestsCasaDelLibro.cookiesPageElements();
            TestsCasaDelLibro.acceptCookies();
            //TestsCasaDelLibro.catalogoPage();
            TestsCasaDelLibro.checkFiccion();
            //TestsCasaDelLibro.productoPage();
            TestsCasaDelLibro.checkProductoPage();
            TestsCasaDelLibro.addCarrito();
            TestsCasaDelLibro.isCartOpen();
            TestsCasaDelLibro.isCartEmpty();
        } catch (AssertionError | Exception e) {
            e.printStackTrace();
            System.exit(-1);
            throw e;
        }

    }

    public void test_5_CartIsNotEmpty() throws InterruptedException {

        try{
            TestsCasaDelLibro.cookiesPageElements();
            TestsCasaDelLibro.acceptCookies();
            //TestsCasaDelLibro.catalogoPage();
            TestsCasaDelLibro.checkFiccion();
            //TestsCasaDelLibro.productoPage();
            TestsCasaDelLibro.checkProductoPage();
            TestsCasaDelLibro.addCarrito();
            TestsCasaDelLibro.isCartOpen();
            TestsCasaDelLibro.cerrarCarrito();
            TestsCasaDelLibro.addCarrito();
            TestsCasaDelLibro.isCartNotEmptyHome();
        } catch (AssertionError | Exception e) {
            e.printStackTrace();
            System.exit(-1);
            throw e;
        }
    }
}

