package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Locale;

/** "Test 1 : Selecciona país/idioma" */
public class SelectCountryAndLanguage extends Base {
    protected static WebDriver driver;
    static By acceptCookiesLocator = By.id("onetrust-accept-btn-handler");
    static By comboboxSeleccionarPaís = By.id("country-list-controls");
    //STATIC By selectCountryLocator = By.xpath("//span[text()='Ireland']");
    static By selectCountryLocator = By.xpath("//span[text()='Germany']");
    //static By selectCountryLocator = By.xpath("//span[text()='Mexico']");
    //static By selectCountryLocator = By.xpath("//span[text()='España']");

    static By selectLanguageLocator = By.xpath("//span[normalize-space()='en']");
    static By pressGOLocator = By.xpath("//span[normalize-space()='GO!']");
    static By pressGuardarLocator = By.xpath("//span[normalize-space()='Guardar']");


    public SelectCountryAndLanguage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public static void selectCountryAndLanguage() throws InterruptedException {
        System.out.println("Se ha ejecutado el primer test");
        driver.manage().window().maximize();
        driver.get("https://www.bershka.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement element= wait.until(ExpectedConditions.visibilityOfElementLocated(acceptCookiesLocator));
            } catch (Exception e) {
            System.out.println("El elemento no es visible dentro del tiempo esperado");
        }
        // ASSERTS :
        boolean cookiesPopUp = false;
        cookiesPopUp = isDisplayed(acceptCookiesLocator);
        Assert.assertTrue(cookiesPopUp, "No se muestra el pop up de cookies");
        // 1º) ¿Se muestra el pop-up de cookies? -> Sí.
        //Comprueba que la condicion buleana de dentro del parantesis , sea cierta
        /**Assert.assertTrue(true, " Error, este parametro no es true.");

        //Comprobar si dos valores son iguales.
        Assert.assertEquals("Hola Julio", "Hola Maria", "Mensaje de error para imprimir por pantalla" );
        //Comprobar si es false
        if(Base.isDisplayed(acceptCookiesLocator)){
            System.out.println("el selector está en la pantalla");
        }else{
            Assert.fail("Error, el selector no estaba en la pantalla");
        }**/

        

        // 2º) ¿Hay un link a la politica de cookies que abre un pdf? -> Sí (aquí he encontrado un error porque NO abre una pestaña nueva).
        // 3º) ¿Cuántos botones tiene el pop-up de cookies? -> 3.
        String botonAceptarCookiesTexto = "";
        botonAceptarCookiesTexto = driver.findElement(acceptCookiesLocator).getText().trim().toLowerCase(Locale.ROOT);
        Assert.assertEquals(botonAceptarCookiesTexto, "aceptar todas las cookies", "Error, el botón de aceptar el texto del pop up de aceptar cookies no es el correcto");
        // 4º) ¿Son clickables estos 3 botones anteriores? -> Sí.
        // 5º) ¿El 1º y 2º botón son con texto de color blanco y background negro, y el 3º viceversa? -> Sí.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        /** Aceptar pop-up de cookies */
        click(acceptCookiesLocator);
        // ASSERTS :
        // 1º) ¿Se muestra el combobox con un valor por defecto? -> Sí.
        // 2º) ¿Se muestra un listado horizontal de checkbox/es con el/los idioma/s del país por defecto? -> Sí.
        // 3º) ¿Hay un footer con un listado de links? -> Sí.
        // 4º) ¿Cuántos links tiene este listado anterior? -> 6.
        // 5º) ¿Hay un texto en el margen inferior derecho con valor "© 2024 BERSHKA"? -> Sí.
        /** Localizar Elemento combobox "Seleccionar País" con id */
        if(isDisplayed(comboboxSeleccionarPaís)){
            /** Click en el Combobox */
            click(comboboxSeleccionarPaís);
            Thread.sleep(3000);
        } else{
            Assert.fail("ERROR: No se muestra el combox de selección de país");
        }
        /** Localizar Elemento "País" con xpath de text()) */
        if (isDisplayed(selectCountryLocator)){
            /** Elegir país*/
            click(selectCountryLocator);
            // ASSERTS - seleccionamos Ireland :
            // 1º) ¿Se muestra seleccionado "Ireland" en el combobox? -> Sí.
            // 2º) ¿Cuántos idiomas se muestran para este país? -> 1. ¿Y cual és? -> EN.
            // 3º) ¿Se muestra visible el checkbox de "Recordar mi selección? -> Sí.
            // 4º) ¿Es desmarcable/marcable este checkbox? -> Sí.
            // 5º) ¿Se muestra visible el botón "GUARDAR" ó "GO!"? -> Sí.

            // ASSERTS - seleccionamos Germany :
            // 1º) ¿Se muestra seleccionado "Germany" en el combobox? -> Sí.
            // 2º) ¿Cuántos idiomas se muestran para este país? -> 2. ¿Y cuales son? -> DE y EN.
            // 3º) ¿Se muestra visible el checkbox de "Recordar mi selección? -> Sí.
            // 4º) ¿Es desmarcable/marcable este checkbox? -> Sí.
            // 5º) ¿Se muestra visible el botón "GUARDAR" ó "GO!"? -> Sí.

            // ASSERTS - seleccionamos Mexico :
            // 1º) ¿Se muestra seleccionado "Mexico" en el combobox? -> Sí.
            // 2º) ¿Cuántos idiomas se muestran para este país? -> 2. ¿Y cuales son? -> ES y EN.
            // 3º) ¿Se muestra visible el checkbox de "Recordar mi selección? -> Sí.
            // 4º) ¿Es desmarcable/marcable este checkbox? -> Sí.
            // 5º) ¿Se muestra visible el botón "GUARDAR" ó "GO!"? -> Sí.

            // ASSERTS - seleccionamos España :
            // 1º) ¿Se muestra seleccionado "España" en el combobox? -> Sí.
            // 2º) ¿Cuántos idiomas se muestran para este país? -> 5. ¿Y cuales son? -> ES-CA-GL-EU y EN.
            // 3º) ¿Se muestra visible el checkbox de "Recordar mi selección? -> Sí.
            // 4º) ¿Es desmarcable/marcable este checkbox? -> Sí.
            // 5º) ¿Se muestra visible el botón "GUARDAR" ó "GO!"? -> Sí.
        }

        /** Elegir idioma prueba */
        if (isDisplayed(selectLanguageLocator)) {
            click(selectLanguageLocator);
            // ASSERTS - seleccionar idioma para caso France :
            // 1º ¿Se muestra seleccionado por defecto el primer elemento de la lista horizontal? -> Sí.
            // 2º ¿Cuál es este primer elemento? -> FR.
            // 3º ¿El idioma que selecciono se muestra en blanco el texto y en negro el background? ¿y el resto viceversa ? -> Sí.
            // 4º ¿Se muestra visible el literal "Selecciona tu idioma"? -> Sí.
        } else {
            System.out.println("Language was not found");
        }
        /**Click para acceder a la web ya seleccionado país e idioma*/
        if (isDisplayed(pressGOLocator)) {
            boolean gobuttonExists = false;
            boolean buttonGo = isDisplayed(acceptCookiesLocator);
            Assert.assertTrue(cookiesPopUp, "No se muestra el pop up de cookies");
            // ASSERTS - se muestra el botón guardar :
            // 1º ¿Se muestra el botón GUARDAR? -> Sí.
            // 2º ¿Es clickable este botón? -> Sí.
            // 3º ¿Al hacer hover con el cursor sobre este botón se realiza el efecto iluminarse? -> Sí.
            // 4º ¿Al clickar en el mismo a que URL redirige? -> a https://www.bershka.com/es/en (para el caso de España y idioma Inglés).
            System.out.println("Es accesible el botón GO!");
            click(pressGOLocator);

        }
        if (isDisplayed(pressGuardarLocator)){
            System.out.println("Es accesible el botón GUARDAR para avanzar segunda prueba Elia");
            click(pressGuardarLocator);
            // ASSERTS - Llegamos a HOME (Selector de género) :
            // 1º ¿Se muestra el logo? -> Sí.
            // 2º ¿Cuántos géneros se muestran? -> 3.
            // 3º ¿Se muestra el pop-up de guardar tu ubicación? -> Sí.
            // 4º ¿Se muestra el botón de pais/idioma en el footer? -> Sí.
            // 5º ¿Qué valores se muestran en este botón para el caso de España con idioma Inglés? -> "España|Ingles"
        }
    }
}
