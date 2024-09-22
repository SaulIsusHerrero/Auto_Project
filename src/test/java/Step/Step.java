package Step;

import org.example.Environments;
import org.openqa.selenium.WebDriver;
import page.CookiesPage;
import page.HomePage;
import page.CarritoPage;

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



}
