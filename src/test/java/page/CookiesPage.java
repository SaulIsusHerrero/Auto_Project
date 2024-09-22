package page;

import org.example.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Locale;

public class CookiesPage extends Base {
    //1º Declare variables
    protected static WebDriver driver;

    //2º Locators
    static By popupCookies = By.xpath("//div[@id='onetrust-group-container']");
    static By configurarCookies = By.xpath("//button[@id='onetrust-pc-btn-handler']");
    static By rechazarCookies = By.xpath("//button[@id='onetrust-reject-all-handler']");
    static By acceptCookiesLocator = By.xpath("//button[@id='onetrust-accept-btn-handler']");

    //3º Constructor
    public CookiesPage(WebDriver driver) {
        super(driver);
        CookiesPage.driver = driver;
    }

    public CookiesPage cookiesPageElements() throws InterruptedException {
        System.out.println("Se ha ejecutado el primer test");
        driver.manage().window().maximize();
        driver.get("https://www.casadellibro.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String textoConfigurarCookies = "";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        textoConfigurarCookies = driver.findElement(configurarCookies).getText().trim().toLowerCase(Locale.ROOT);
        String textoRechazarCookies = "";
        textoRechazarCookies = driver.findElement(rechazarCookies).getText().trim().toLowerCase(Locale.ROOT);
        String textoAceptarCookiesTexto = "";
        textoAceptarCookiesTexto = driver.findElement(acceptCookiesLocator).getText().trim().toLowerCase(Locale.ROOT);

        Assert.assertTrue(isDisplayed(popupCookies), "No es mostrado el pop up de cookies");
        Assert.assertEquals(textoConfigurarCookies, "configurar cookies", "Error, el texto del botón de configurar cookies no es el correcto");
        Assert.assertEquals(textoAceptarCookiesTexto, "aceptar", "Error, el texto del botón de aceptar todas las cookies no es el correcto");
        Assert.assertEquals(textoRechazarCookies, "rechazar", "Error, el texto del botón de rechazar no es el correcto");
        return this;
    }

    public CookiesPage acceptCookies() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        /** Aceptar pop-up de cookies */
        click(configurarCookies);
        Thread.sleep(1000);
        Assert.assertFalse(isDisplayed(popupCookies), "No se ha cerrado el pop up de cookies");
        return this;
    }





}
