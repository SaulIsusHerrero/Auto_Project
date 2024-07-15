package org.example.Pages;

import org.example.Base;
import org.openqa.selenium.WebDriver;


public class CookiesPage  extends Base {
    //1º Declare variables
    protected static WebDriver driver;

    //2º Locators


    //3º Constructor
    public CookiesPage(WebDriver driver) {
        super(driver);
        CookiesPage.driver = driver;
    }

    //4ºMethods



}