package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
public class Base {
    //1º Variables
    protected static WebDriver driver;
    //2º Locators
    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }
    //3º Constructor
    public Base(WebDriver driver) {
        this.driver = driver;
    }
    //4º Methods
    public void type(String inputText, By locator) {
        driver.findElement(locator).sendKeys(inputText);
    }

    public static void click(By locator) {
        driver.findElement(locator).click();
    }

    public static Boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public Boolean isEnabled(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}