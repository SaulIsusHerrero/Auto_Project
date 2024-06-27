package org.example;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectCountryAndLanguage extends Base {
    static By acceptCookiesLocator = By.id("onetrust-accept-btn-handler");
    static By selectLanguageLocator = By.xpath("//span[normalize-space()='en']");
    static By selectCountrySelectorLocator = By.id("country-list-controls");
    static By selectCountryLocatorArgentina = By.xpath("//span[text()='Argentina']");
    static By selectCountryLocatorIreland = By.xpath("//span[text()='Ireland']");
    static By selectCountryLocatorFrance = By.xpath("//span[text()='France']");
    static By selectCountryLocatorMexico = By.xpath("//span[text()='Mexico']");
    static By selectCountryLocatorEspaña = By.xpath("//span[text()='España']");
    static By pressGOLocator = By.xpath("//button[@aria-label='Guardar']");
    By genderImageLocator = By.cssSelector(".gender-selector__image");
    By logoImageLocator = By.xpath("//h1[@class='super-home-gender-selector__title']//*[name()='svg']");

    public SelectCountryAndLanguage(WebDriver driver) {
        super(driver);
    }

    public static void selectCountryAndLanguage() throws InterruptedException {
        System.out.println("Se ha ejecutado el primer test");
        driver.manage().window().maximize();
        driver.get("https://www.bershka.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20L));
        Thread.sleep(4000L);
        click(acceptCookiesLocator);
        Thread.sleep(5000L);

        // Seleccionar países
        selectCountry("Argentina");
        selectCountry("Ireland");
        selectCountry("France");
        selectCountry("Mexico");
        selectCountry("España");

        // Seleccionar idioma
        if (isDisplayed(selectLanguageLocator)) {
            //ASSERT: Verificación de que el idioma 'EN' está disponible
            click(selectLanguageLocator);
            Thread.sleep(2000L);
        } else {
            //ASSERT: Verificación de que el idioma 'EN' NO está disponible
            System.out.println("Language 'EN' was not found");
        }

        // Hacer clic en el botón Guardar
        if (isDisplayed(pressGOLocator)){
            //ASSERT: Verificación de que el botón Guardar está disponible
            System.out.println("Es accesible el boton GUARDAR");
            click(pressGOLocator);
            Thread.sleep(5000L);
        } else {
            //ASSERT: Verificación de que el botón Guardar no está disponible
            System.out.println("El botón GUARDAR no es accesible");
        }
    }

    private static void selectCountry(String country) throws InterruptedException {
        click(selectCountrySelectorLocator);
        Thread.sleep(2000L);
        By countryLocator = By.xpath("//span[text()='" + country + "']");
        click(countryLocator);
        Thread.sleep(2000L);
    }

    public void webAccess() throws InterruptedException {
        click(pressGOLocator);
        Thread.sleep(5000L);
        if (this.isEnabled(this.genderImageLocator)) {
            click(this.genderImageLocator);
            Thread.sleep(5000L);
            if (isDisplayed(this.logoImageLocator)) {
                //ASSERT: Verificación de que la imagen del logo está visible
                System.out.println("TEST 1 PASSED : Logo image found");
            } else {
                //ASSERT: Verificación de que la imagen del logo no está visible
                System.out.println("Logo image was not found");
            }
        } else {
            //ASSERT: Verificación de que la imagen del selector de género no está habilitada
            System.out.println("Gender selector image was not found");
        }
    }
    //haciendo commit de prueba- eli
}
