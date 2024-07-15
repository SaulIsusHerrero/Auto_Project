package org.example.Pages;

import org.example.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Locale;

public class CountryPage  extends Base {
    //1º Declare variables
    protected static WebDriver driver;

    //2º Locators


    //3º Constructor
    public CountryPage(WebDriver driver) {
        super(driver);
        CookiesPage.driver = driver;
    }

    //4ºMethods



}