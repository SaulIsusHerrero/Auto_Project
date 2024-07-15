package org.example.Pages;

import org.example.Base;
import org.openqa.selenium.WebDriver;


public class SuperHomePage  extends Base {
    //1º Declare variables
    protected static WebDriver driver;

    //2º Locators


    //3º Constructor
    public SuperHomePage(WebDriver driver) {
        super(driver);
        CookiesPage.driver = driver;
    }

    //4ºMethods



}