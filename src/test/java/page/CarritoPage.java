package page;

import org.example.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CarritoPage extends Base {
    //1º Declare variables
    protected static WebDriver driver;

    //2º Locators
    static By cartModalLocator = By.id("aria-modal-shopcart");
    static By cestaTitulo =By.xpath("//button[@class='btn ghost icon ml-auto']");
    static By cestaX =By.xpath("//button[@class='btn ghost icon ml-auto']");
    static By cestaVacia = By.xpath("//strong[@class='f-size-4 s-7-text']");
    static By cartButton = By.xpath("//button[@class='btn icon ghost brand-text cesta-btn']");

    //3º Constructor
    public CarritoPage(WebDriver driver) {
        super(driver);
        CookiesPage.driver = driver;
    }
    public CarritoPage carritoPageDefaultElements() throws InterruptedException {
        Thread.sleep(1000);
        clickAndWait(cartButton);
        Thread.sleep(3000);
        Assert.assertFalse(isDisplayed(cartModalLocator),"No se muestra el modal del carrito");
        Assert.assertTrue(isDisplayed(cestaTitulo), "Titulo 'Tu cesta' se muestra");
        Assert.assertTrue(isDisplayed(cestaX), "Si hay un boton X de Cesta");
        Assert.assertTrue(isDisplayed(cestaVacia),"Aparece el texto 'Tu cesta esta vacia'");
        return this;
    }
    public CarritoPage cerrarCarrito() throws InterruptedException {
        click(cestaX);
        Assert.assertTrue(isDisplayed(cestaX),"No se ha cerrado la modal del carrito con X ");
        return this;
    }
}
