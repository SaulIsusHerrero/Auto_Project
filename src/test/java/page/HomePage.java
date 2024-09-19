package page;

import org.example.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage extends Base {

    //1º Declare variables
    protected static WebDriver driver;

    //2º Locators

    static By cartButton = By.xpath("//button[@class='btn icon ghost brand-text cesta-btn']");

    //3º Constructor
    public HomePage(WebDriver driver) {
        super(driver);
        CookiesPage.driver = driver;
    }


//   public HomePage openContryCombobox()  {
//       /** Localizar Elemento combobox "Seleccionar País" con id */
//       dynamicWait(espanaDropDwn);
//       if (isDisplayed(comboboxSeleccionarPais)) {
//           /** Click en el Combobox */
//           click(comboboxSeleccionarPais);
//       } else {
//           Assert.fail("ERROR: No se muestra el combox de selección de país");
//       }
//       return this;
//   }


}
