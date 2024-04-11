package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

/**"Test 1 : Selecciona país/idioma y encuentra el logo de BERSHKA")*/
public class SelectCountryAndLanguage extends Base {
    private static WebDriver driver;
    static By acceptCookiesLocator = By.id("onetrust-accept-btn-handler");
    static By selectLanguageLocator = By.xpath("//span[normalize-space()='en']");
    By pressGOLocator = By.cssSelector("button[aria-label='GO!']");
    By genderImageLocator = By.cssSelector(".gender-selector__image");
    By logoImageLocator = By.xpath("//h1[@class='super-home-gender-selector__title']//*[name()='svg']");

    public SelectCountryAndLanguage(WebDriver driver) {
        super(driver);
    }
    public static void selectCountryAndLanguage() throws InterruptedException {
        System.out.println("Se ha ejecutado el primer test");
        driver.manage().window().maximize();
        driver.get("https://www.bershka.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        /**Aceptar pop-up de cookies*/
        click(acceptCookiesLocator);
        Thread.sleep(5000);
        if (isDisplayed(selectLanguageLocator)) {
            /**Seleccionar idioma EN*/
            click(selectLanguageLocator);
            Thread.sleep(5000);
        } else {
            System.out.println("Language 'EN' was not found");
        }
    }

    public void webAccess() throws InterruptedException {
        /**Click para acceder a la web ya seleccionado país e idioma*/
        click(pressGOLocator);
        Thread.sleep(5000);
        /**Comprobamos que la imágen del género esté habilitada*/
        if (isEnabled(genderImageLocator)) {
            /**Hacemos click para seleccionar género y entrar en la Home Page*/
            click(genderImageLocator);
            Thread.sleep(5000);
            /**Comprobamos que existe la imagen del logo*/
            if (isDisplayed(logoImageLocator)) {
                System.out.println("TEST 1 PASSED : Logo image found");
            } else {
                System.out.println("Logo image was not found");
            }
        } else {
            System.out.println("Gender selector image was not found");
        }
    }
}
