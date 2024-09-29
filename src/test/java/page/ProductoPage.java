package page;
import org.example.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static page.CatalogoPage.breadCrumbs;
import static page.CatalogoPage.imagen1erLibro;

public class ProductoPage extends Base {

    //1º Declare variables
    protected static WebDriver driver;

    // Locators
    static By addToCartLocator = By.xpath("//button[@class='btn accent f-w-6 svelte-80ls0o']");
    static By tituloProducto = By.xpath("//h1[@class='f-serif balance-title f-fluid-2 f-w-4 mb-2 svelte-xvuu2q']");
    static By autorProducto = By.xpath("(//div[@class='f-serif s-7-text f-fluid-1'])");
    static By precioProducto = By.xpath("(//div[@class='info-price d-grid svelte-1c4mio6'])");
    static By carritoConProducto_s = By.xpath("(//div[@class='f-size-3 f-serif my-2'])");

    public ProductoPage(WebDriver driver) {
        super(driver);

    }

    // Tests
    public static void checkProductoPage () throws InterruptedException {
        clickAndWait(imagen1erLibro);
        dynamicWait(tituloProducto);
        Assert.assertTrue(isDisplayed(breadCrumbs),"No aparece el breadcrumb'");
        Assert.assertTrue(isDisplayed(tituloProducto), "No se muestra el título del producto");
        Assert.assertTrue(isDisplayed(autorProducto), "No se muestra el/la autor/a del producto");
        Assert.assertTrue(isDisplayed(precioProducto), "No se muestra el precio del producto");
    }
    public ProductoPage addCarrito() throws InterruptedException {
        click(addToCartLocator);
        Assert.assertTrue(isDisplayed(carritoConProducto_s), "El producto no está en el carrito");
        return this;
    }
}
