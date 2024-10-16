package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Ejecutable_de_Tests {
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
    @DisplayName("Test 1 : Aceptamos cookies y añadimos al carrito un producto")

    public void test_1_Aceptar_Cookies_Y_Añadir_A_Carrito() throws InterruptedException {

        try{
            TestsCasaDelLibro.cookiesPageElements();
            TestsCasaDelLibro.acceptCookies();
            TestsCasaDelLibro.carritoPageDefaultElements();
            TestsCasaDelLibro.cerrarCarrito();
            TestsCasaDelLibro.acceder_a_Imprescindibles();
            TestsCasaDelLibro.checkProductoPage();
            TestsCasaDelLibro.addCarrito();
        } catch (AssertionError | Exception e) {
            e.printStackTrace();
            System.exit(-1);
            throw e;
        }
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test 2 : Accedemos al buscador, hacemos una búsqueda")

    public void test_2_Buscador() throws InterruptedException {

        try{
            TestsCasaDelLibro.cookiesPageElements();
            TestsCasaDelLibro.acceptCookies();
            System.out.println("test del Buscador");
            testsCasaDelLibro.buscarProducto();
        } catch (AssertionError | Exception e) {
            e.printStackTrace();
            System.exit(-1);
            throw e;
        }
    }
}