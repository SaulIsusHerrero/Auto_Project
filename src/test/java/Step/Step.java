package Step;

import org.example.Environments;
import org.openqa.selenium.WebDriver;
import page.*;

public class Step {

    protected static WebDriver driver;
    public Step(WebDriver driver) {
        super();
        Step.driver = driver;
    }

    public void goTo(){
       new Environments(driver).goToPro();
    }

    public void manageCookies() throws InterruptedException {
        CookiesPage cookies = new CookiesPage(driver);
        cookies.cookiesPageElements().acceptCookies();
    }

    public void manageCarrito() throws InterruptedException {
        CarritoPage carrito = new CarritoPage(driver);
        carrito.carritoPageDefaultElements().cerrarCarrito();
    }

    public void manageCatalogo() throws InterruptedException{
        CatalogoPage catalogo = new CatalogoPage(driver);
        catalogo.checkFiccion();
    }
    public void manageProducto() throws InterruptedException {
        ProductoPage producto = new ProductoPage(driver);
        producto.checkProductoPage();
        producto.addCarrito();
    }
    public void manageHome() throws InterruptedException{
        HomePage home = new HomePage(driver);
        home.isCartNotEmptyHome();
    }
}
