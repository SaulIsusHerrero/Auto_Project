package page;

import org.example.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class HomePage extends Base {

    //1º Declare variables
    protected static WebDriver driver;

    //2º Locators
    static By cartButton = By.xpath("//button[@class='btn icon ghost brand-text cesta-btn']");
    static By cartNumber = By.xpath("//span[@class='svelte-wwa3op']");
    static By cestaX =By.xpath("//button[@class='btn ghost icon ml-auto']");

    //3º Constructor
    public HomePage(WebDriver driver) {
        super(driver);
        CookiesPage.driver = driver;
    }

    public static void cerrarCarrito() throws InterruptedException {
        click(cestaX);
        Thread.sleep(2000);
        System.out.println("La modal del carrito se ha cerrado con la X");
        //Aseguramos que la modal del carrito se ha cerrado.
        Assert.assertFalse(isDisplayed(cestaX),"Sí se muestra la modal del carrito");
    }

    public static void isCartNotEmptyHome () throws InterruptedException {
        cerrarCarrito();
        boolean b = driver.findElements(cartNumber).size() > 0;
        //Aseguramos que el carrito no está vacío desde su visión desde la Home
        Assert.assertTrue(isDisplayed(cartNumber), "Se muestra el nº de elementos del carrito desde la Home y no es 0");
    }
}
