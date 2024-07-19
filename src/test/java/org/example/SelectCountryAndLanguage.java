package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Locale;

/*"Test 1 : Selecciona país/idioma"*/
public class SelectCountryAndLanguage extends Base {
    //@SAUL: todo clean code el código. toda clase de page object tiene que tener declaración de variables, declaración de selectores, constructor,metodos
    //1º Variables
    protected static WebDriver driver;

    //2º Locators
    static By acceptCookiesLocator = By.id("onetrust-accept-btn-handler");
    static By rejectOptionalCookiesLocator = By.id("onetrust-reject-all-handler");
    static By cookiesConfiguration = By.id("onetrust-pc-btn-handler");
    static By comboboxSeleccionarPaís = By.id("country-list-controls");
    static By selectCountryLocator = By.xpath("//span[text()='Germany']");
    static By selectLanguageLocator = By.xpath("//span[normalize-space()='en']");
    static By pressGOLocator = By.xpath("//span[normalize-space()='GO!']");
    static By pressGuardarLocator = By.xpath("//span[normalize-space()='Guardar']");
    static By policyLink = By.xpath("//a[@class='ot-cookie-policy-link']");
    static By womanLink = By.xpath("//a[@href='/es/h-woman.html']");
    static By cartButton = By.id("aria-button-shopcart");
    static By wishListButton = By.xpath("//a[@href='/es/wish-list.html']");

    //3º Constructor
    public SelectCountryAndLanguage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //4º Methods
    public static void selectCountryAndLanguage() throws InterruptedException {
        //Paso 1.Ir a la pagina de Berska
        System.out.println("Se ha ejecutado el primer test");
        driver.manage().window().maximize();
        driver.get("https://www.bershka.com/");

        //Paso 2. Aceptar las cookies
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(acceptCookiesLocator));
        } catch (Exception e) {
            System.out.println("El elemento no es visible dentro del tiempo esperado");
        }
        boolean cookiesPopUp = isDisplayed(acceptCookiesLocator);
        Assert.assertTrue(cookiesPopUp, "No es mostrado el pop up de cookies");

        //@SAUL: todo poner todos los pasos y quitas cosas que sobren

        //@SAUL: todo verificar que existe el link de la política de privacidad
        if(Base.isDisplayed(policyLink)){
            System.out.println("se muestra el link de la política de privacidad.");
        }else{
            Assert.fail("Error, no se muestra el link de la política de privacidad.");
        }
        //driver.findElement(policyLink).click(); Se comenta esta linea porque al no abrir el PDF en otra pestaña del browser el test no prosigue

        //@SAUL: todo comprobar que aparece el texto de los tres botones
        String botonAceptarCookiesTexto = "";
        String botonRechazarOpcionales = "";
        String botonConfiguracionCookies = "";
        botonAceptarCookiesTexto = driver.findElement(acceptCookiesLocator).getText().trim().toLowerCase(Locale.ROOT);
        botonRechazarOpcionales = driver.findElement(rejectOptionalCookiesLocator).getText().trim().toLowerCase(Locale.ROOT);
        botonConfiguracionCookies = driver.findElement(cookiesConfiguration).getText().trim().toLowerCase(Locale.ROOT);
        Assert.assertEquals(botonAceptarCookiesTexto, "aceptar todas las cookies", "Error, el texto del botón de aceptar todas las cookies no es el correcto");
        Assert.assertEquals(botonRechazarOpcionales, "rechazar opcionales", "Error, el texto del botón de rechazar las cookies opcionales no es el correcto");
        Assert.assertEquals(botonConfiguracionCookies, "configuración de cookies", "Error, el texto del botón de configuración de cookies no es el correcto");

        //@todo buscar en internet como se comprueba si algo es clicable

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        /** Aceptar pop-up de cookies */
        click(acceptCookiesLocator);
        //@todo comprobar que los links están

        //@todo comprobar el texto
        /** Localizar Elemento combobox "Seleccionar País" con id */
        if (isDisplayed(comboboxSeleccionarPaís)) {
            /** Click en el Combobox */
            click(comboboxSeleccionarPaís);
            Thread.sleep(3000);
        } else {
            Assert.fail("ERROR: No se muestra el combox de selección de país");
        }

        //@todo intentar quitar el Thread.sleep de la linea 88 y poner una espera dinámica
        /** Localizar Elemento "País" con xpath de text()) */
        if (isDisplayed(selectCountryLocator)) {
            /** Elegir país*/
            click(selectCountryLocator);
            //@todo comprobar que el localizador del checkbox esta visible

            //@todo comprobar que esta presente el botón guardar o go .
        }

        /** Elegir idioma prueba */
        if (isDisplayed(selectLanguageLocator)) {
            click(selectLanguageLocator);
        } else {
            System.out.println("Language was not found"); //@todo Assert
        }
        /**Click para acceder a la web ya seleccionado país e idioma*/
        if (isDisplayed(pressGOLocator)) {
            boolean gobuttonExists = false;
            boolean buttonGo = isDisplayed(acceptCookiesLocator);
            Assert.assertTrue(cookiesPopUp, "No se muestra el pop up de cookies");
            System.out.println("Es accesible el botón GO!");
            click(pressGOLocator);

        }
        if (isDisplayed(pressGuardarLocator)) {
            System.out.println("Es accesible el botón GUARDAR para avanzar segunda prueba Elia");
            click(pressGuardarLocator);
        } else {
            Assert.fail(null);
        }
        clickAndWait(womanLink);
        //@todo si no ha aparecido el Go ni el Guardar, Assert.fail


        //@todo clicar en el símbolo del carrito (esto abre la pestaña de la cesta)
        //@todo Categoría: Difícil -- comprobar que se abre la pestaña de la cesta. Pista, hay un localizador (#aria-modal-shopcart) que tiene un atributo cuyo valor cambia cuando aparece la cesta.

        //@todo (comprobar que no hay elementos, la cesta está vacia)
        //@todo click en descubrir -- te lleva a descubrir nuevos productos
        //@todo assert para comprobar que se abre la página "New"  (NOta: intentad buscar un localizador que esté presente solo cuando se abre está página)
        //@todo click en la opción "Jeans"
        //@todo Categoría: Difícil-->comprobar que se activa el botón "jeans" Pista: en el localizador del botón, cuando se clica uno de los atributos también cambia :)
        //@SAUL todo volver a clicar en el símbolo de la cesta
        clickAndWait(cartButton);
        //@SAUL todo click en favoritos
        clickAndWait(wishListButton);
        //@todo verificar con assert que estoy en la página de favoritos  (NOta: intentad buscar un localizador que esté presente solo cuando se abre está página)

        //@todo verificar que no hay nada en favoritos
    }
}