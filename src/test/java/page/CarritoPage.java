package page;

import org.example.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static page.HomePage.cartButton;

public class CarritoPage extends Base {
    //1º Declare variables
    protected static WebDriver driver;

    //2º Locators
    static By cartModalLocator = By.id("aria-modal-shopcart");
    static By emptyCartMessageLocator = By.xpath("//section[@id='aria-modal-shopcart']//div[@class='svg-item'] ");
    static By cestaTitulo =By.xpath("//button[@class='btn ghost icon ml-auto']");
    static By cestaX =By.xpath("//button[@class='btn ghost icon ml-auto']");
    static By cestaVacia = By.xpath("//strong[@class='f-size-4 s-7-text']");

    //3º Constructor
    public CarritoPage(WebDriver driver) {
        super(driver);
        CookiesPage.driver = driver;
    }


    public CarritoPage carritoPageDefaultElements() throws InterruptedException {
        //TODO: Adaptamos este test al carrito de CasaDelLibro
        //(2)@todo clicar en el símbolo del carrito (esto abre la pestaña de la cesta)
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
// TODO: Deberes 5 de Septiembre 2:
//  1. Crear assert/s para comprobar que se cierra el modal de carrito al pulsar x
        click(cestaX);
        Assert.assertTrue(isDisplayed(cestaX),"No se ha cerrado la modal del carrito con X ");
        return this;
    }




}
