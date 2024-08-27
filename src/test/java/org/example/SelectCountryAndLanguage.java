package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
    static By comboboxSeleccionarPaís = By.xpath("//div[@class='country-selector country-selection__cta']");
    static By espanaDropDwn= By.xpath("//span[normalize-space(text())='España'][@class='caption-name']");
    static By selectCountryLocator = By.xpath("//span[text()='España']");
    static By selectLanguageLocator = By.xpath("//span[normalize-space()='en']");
    static By pressGOLocatorGeneral = By.xpath("//button[@data-qa-anchor='saveLocation']");
    static By policyLink = By.xpath("//a[@class='ot-cookie-policy-link']");
    //static By womanLink = By.xpath("//div[@class='gender-selector super-home-gender-selector__menu']/div/div[1]/a");

    static By womanLink = By.xpath("//a[contains(@href, 'woman')]");

    static By cartButton = By.xpath("//button[@id='aria-button-shopcart']");
    static By wishListButton = By.xpath("//span[@class='wishlist-button__text']");
    static By wLPageTitle = By.xpath("//h1[@class='top-bar-title-desktop bds-typography-heading-s']");
    static By wLEmpty = By.xpath("//div[@class='empty recommendation-empty-state wishlist-product-grid__empty recommendation-empty-state--carousel']");
    static By cartDescubrirButton = By.xpath("//a[@class='link-text button is-black']");
    static By titleCategoryNew = By.xpath("//h1[@class='top-bar-title-desktop bds-typography-heading-s']");
    static By jeansCarruselParrillaNew = By.xpath("//button[normalize-space()='Jeans']");
    static By cartModalLocator = By.id("aria-modal-shopcart");
    static By emptyCartMessageLocator = By.xpath("//section[@id='aria-modal-shopcart']//div[@class='svg-item'] ");

    //Jorge comprobar cesta 1
    //(3)@todo Categoría: Difícil -- comprobar que se abre la pestaña de la cesta. Pista, hay un localizador (#aria-modal-shopcart) que tiene un atributo cuyo valor cambia cuando aparece la cesta.
    public static boolean isCartOpen(){
        WebElement cartModal = driver.findElement(cartModalLocator);
        String ariaExpanded = cartModal.getAttribute("aria-expanded");
        return "false".equals(ariaExpanded);
    }
    //Jorge 4
    //@todo (comprobar que no hay elementos, la cesta está vacia)
    // Metodo para comprobar si la cesta esta vacia
    public static boolean isCartEmpty(){
        return driver.findElements(emptyCartMessageLocator).size() > 0;
    }


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
        dynamicWait(espanaDropDwn);
        if (isDisplayed(comboboxSeleccionarPaís)) {
            /** Click en el Combobox */
            clickAndWait(comboboxSeleccionarPaís);
        } else {
            Assert.fail("ERROR: No se muestra el combox de selección de país");
        }

        //@todo intentar quitar el Thread.sleep de la linea 88 y poner una espera dinámica
        /** Localizar Elemento "País" con xpath de text()) */
        dynamicWait(selectCountryLocator);
            /** Elegir país*/
            clickAndWait(selectCountryLocator);
            //@todo comprobar que el localizador del checkbox esta visible

            //@todo comprobar que esta presente el botón guardar o go .


        /** Elegir idioma prueba */
        if (isDisplayed(selectLanguageLocator)) {
            click(selectLanguageLocator);
        } else {
            System.out.println("Language was not found"); //@todo Assert
        }

        //(1) @todo si no ha aparecido el Go ni el Guardar, Assert.fail
        boolean isGoButtonVisible = isDisplayed(pressGOLocatorGeneral);
        boolean isSaveButtonVisible = isDisplayed(pressGOLocatorGeneral);

        if (isGoButtonVisible) {
            clickAndWait(pressGOLocatorGeneral);
        } else if (isSaveButtonVisible) {
            clickAndWait(pressGOLocatorGeneral);
        } else {
            Assert.fail("Neither GO button nor Guardar button is visible");
        }



        /**Click para acceder a la web ya seleccionado país e idioma*/
        clickAndWait(pressGOLocatorGeneral);

        //Thread.sleep(5000);
        clickAndWait(womanLink);


        //Jorge
        //(2)@todo clicar en el símbolo del carrito (esto abre la pestaña de la cesta)
        Thread.sleep(1000);
        clickAndWait(cartButton);

        //Jorge comprobar cesta 2
        //(3)@todo Categoría: Difícil -- comprobar que se abre la pestaña de la cesta. Pista, hay un localizador (#aria-modal-shopcart) que tiene un atributo cuyo valor cambia cuando aparece la cesta.
        // Aqui esperamos que el atributo "aria-expanded" del modal de la cesta sea falso
        WebDriverWait waitCart = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.attributeToBe(cartModalLocator, "aria-expanded", "true"));
        } catch (Exception e) {
            System.out.println("La cesta NO abrio.");
            //Assert para comprobar que se abre la pestaña de la cesta
            Assert.assertTrue(isCartOpen(), "La pestaña de la cesta no se abrio correctamente");
            System.out.println("La cesta SI se abrio.");
        }

        //@todo click en descubrir -- te lleva a descubrir nuevos productos
        dynamicWait(cartDescubrirButton);
        if (isDisplayed(cartDescubrirButton)) {
            System.out.println("Se muestra el botón Descubrir en cesta vacía");
            clickAndWait(cartDescubrirButton);
        } else { Assert.fail("No se muestra el botón Descubrir en cesta vacía");
        }
        //@todo assert para comprobar que se abre la página "New"  (NOta: intentad buscar un localizador que esté presente solo cuando se abre está página)
        if (isDisplayed(titleCategoryNew)) {
            System.out.println("Se ha accedido correctamente a la página New");
            clickAndWait(titleCategoryNew);
        } else { Assert.fail("No se ha accedido a la página New");
        }
        //@todo click en la opción "Jeans"
        if (isDisplayed(jeansCarruselParrillaNew)) {
            System.out.println("Se muestra la opción Jeans en el carrusel");
            clickAndWait(jeansCarruselParrillaNew);
        } else { Assert.fail("No se muestra la opción Jeans en el carrusel");
        }
        //@todo Categoría: Difícil-->comprobar que se activa el botón "jeans" Pista: en el localizador del botón, cuando se clica uno de los atributos también cambia :)
        //@SAUL todo volver a clicar en el símbolo de la cesta
        clickAndWait(cartButton);
        Assert.assertTrue(driver.findElement(wishListButton).isDisplayed(),"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        System.out.println("He hecho click en cart button AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        //@SAUL todo click en favoritos
        clickAndWait(wishListButton);
        //@SAUL todo verificar con assert que estoy en la página de favoritos  (NOta: intentad buscar un localizador que esté presente solo cuando se abre está página)
        if(Base.isDisplayed(wLPageTitle)){
            System.out.println("Estamos en Favoritos.");
        }else{
            Assert.fail("Error, no estamos en favoritos");
        }
        //@SAUL todo verificar que no hay nada en favoritos
        if(Base.isDisplayed(wLEmpty)){
            System.out.println("Favoritos está vacío.");
        }else{
            Assert.fail("Favoritos no está vacío");
        }
    }
}