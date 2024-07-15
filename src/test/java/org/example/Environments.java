package org.example;

import org.openqa.selenium.WebDriver;

public class Environments extends Base{

    protected static WebDriver driver;

    public Environments(WebDriver driver) {
        super(driver);
        Environments.driver = driver;
    }

    public Environments goToPro(){

        //Paso 1.Ir a la pagina de Berska
        driver.manage().window().maximize();
        driver.get("https://www.bershka.com/");
        System.out.println("Cargando url: https://www.bershka.com/");

        return this;
    }
}
