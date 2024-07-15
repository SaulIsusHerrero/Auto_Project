package page;

import org.example.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Locale;

public class CookiesPage  extends Base {
    //1º Declare variables
    protected static WebDriver driver;

    //2º Locators
    static By acceptCookiesLocator = By.id("onetrust-accept-btn-handler");
    static By rejectOptionalCookiesLocator = By.id("onetrust-reject-all-handler");
    static By cookiesConfiguration = By.id("onetrust-pc-btn-handler");
    static By policyLink = By.xpath("//a[@class='ot-cookie-policy-link']");

    //3º Constructor
    public CookiesPage(WebDriver driver) {
        super(driver);
        CookiesPage.driver = driver;
    }

    public CookiesPage verifyCookiesExist(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
           wait.until(ExpectedConditions.visibilityOfElementLocated(acceptCookiesLocator));
        } catch (Exception e) {
            System.out.println("El elemento no es visible dentro del tiempo esperado");
        }
        boolean cookiesPopUp = isDisplayed(acceptCookiesLocator);
        Assert.assertTrue(cookiesPopUp, "No es mostrado el pop up de cookies");

        return this;
    }

    public CookiesPage verifyLinkPrivacyExist(){

        if(Base.isDisplayed(policyLink)){
            System.out.println("se muestra el link de la política de privacidad.");
        }else{
            Assert.fail("Error, no se muestra el link de la política de privacidad.");
        }

        return this;
    }

    public CookiesPage verifyBotonAceptarCookiesExist(){

        String botonAceptarCookiesTexto = "";
        botonAceptarCookiesTexto = driver.findElement(acceptCookiesLocator).getText().trim().toLowerCase(Locale.ROOT);
        Assert.assertEquals(botonAceptarCookiesTexto, "aceptar todas las cookies", "Error, el texto del botón de aceptar todas las cookies no es el correcto");

        return this;
    }

    public CookiesPage verifyBotonRechazarOpcionalesExist(){

        String botonRechazarOpcionales = "";
        botonRechazarOpcionales = driver.findElement(rejectOptionalCookiesLocator).getText().trim().toLowerCase(Locale.ROOT);
        Assert.assertEquals(botonRechazarOpcionales, "rechazar opcionales", "Error, el texto del botón de rechazar las cookies opcionales no es el correcto");

        return this;
    }

    public CookiesPage verifyBotonConfiguracionCookiesExist(){

        String botonConfiguracionCookies = "";
        botonConfiguracionCookies = driver.findElement(cookiesConfiguration).getText().trim().toLowerCase(Locale.ROOT);
        Assert.assertEquals(botonConfiguracionCookies, "configuración de cookies", "Error, el texto del botón de configuración de cookies no es el correcto");

        return this;
    }

    public CookiesPage acceptCookies(){
        click(acceptCookiesLocator);
        return this;
    }

}
