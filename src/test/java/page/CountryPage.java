package page;

import org.example.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CountryPage extends Base {

    //1º Declare variables
    protected static WebDriver driver;

    //2º Locators
    static By acceptCookiesLocator = By.id("onetrust-accept-btn-handler");
    static By comboboxSeleccionarPais = By.id("country-list-controls");
    /* Otros localizadores para el problema del combobox
     By locator2 = By.cssSelector("div[class='country-selector country-selection__cta']");
       By locator3 = By.cssSelector("button[class='button is-select']");
       By locator4 = By.cssSelector("span[class='icon-container icon-size-16']");
       By locator5 = By.cssSelector("span[class='bskico-arrow-down-16']");
     */
    static By espanaDropDwn= By.xpath("//span[normalize-space(text())='España'][@class='caption-name']");
    static By selectCountryLocator = By.xpath("//span[text()='Germany']");
    static By selectLanguageLocator = By.xpath("//span[normalize-space()='en']");
    static By pressGOLocator = By.xpath("//span[normalize-space()='GO!']");
    static By pressGuardarLocator = By.xpath("//span[normalize-space()='Guardar']");

    //3º Constructor
    public CountryPage(WebDriver driver) {
        super(driver);
        CookiesPage.driver = driver;
    }

   public CountryPage openContryCombobox()  {
       /** Localizar Elemento combobox "Seleccionar País" con id */
       dynamicWait(espanaDropDwn);
       if (isDisplayed(comboboxSeleccionarPais)) {
           /** Click en el Combobox */
           click(comboboxSeleccionarPais);
       } else {
           Assert.fail("ERROR: No se muestra el combox de selección de país");
       }
       return this;
   }

   public CountryPage selectCountry(){
       /** Localizar Elemento "País" con xpath de text()) */
       dynamicWait(selectCountryLocator);
           /** Elegir país*/
           click(selectCountryLocator);
           //@todo comprobar que el localizador del checkbox esta visible

           //@todo comprobar que esta presente el botón guardar o go .

       return this;
   }

   public CountryPage selectLanguage(){

       /** Elegir idioma prueba */
       if (isDisplayed(selectLanguageLocator)) {
           click(selectLanguageLocator);
       } else {
           System.out.println("Language was not found"); //@todo Assert
       }

       return this;
   }

   public CountryPage clickGoGuardar (){

       if (isDisplayed(pressGOLocator)) {
           boolean gobuttonExists = false;
           boolean buttonGo = isDisplayed(acceptCookiesLocator);
           Assert.assertTrue(buttonGo, "No se muestra el botón GO");
           System.out.println("Es accesible el botón GO!");
           click(pressGOLocator);

       } else  if (isDisplayed(pressGuardarLocator)) {
           System.out.println("Es accesible el botón GUARDAR ");
           click(pressGuardarLocator);
       } else {
           Assert.fail(null);
       }

       return this;
   }


}
