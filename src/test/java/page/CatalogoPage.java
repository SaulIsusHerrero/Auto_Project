package page;
import org.example.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
public class CatalogoPage extends Base {

    //1º Declare variables
    protected static WebDriver driver;

    // Locators
    static By catalogoFiccionLocator = By.xpath("//a[normalize-space()='Ficción']");
    static By breadCrumbs = By.xpath("//nav[@aria-label='breadcrumbs']");
    static By title = By.xpath("(//div[@class='compact-product gap-2 px-3 py-2 svelte-9oij4h'])[1]");
    static By imagen1erLibro = By.xpath("(//div[@class='compact-product gap-2 px-3 py-2 svelte-9oij4h'])[1]");

    // Constructor
    public CatalogoPage(WebDriver driver) {
        super(driver);

    }

    // Tests terminados en asserts
    public static void checkFiccion () throws InterruptedException {
        clickAndWait(catalogoFiccionLocator);
        dynamicWait(title);
        Assert.assertTrue(isDisplayed(catalogoFiccionLocator),"No se clickó en categoria ficcion'");
        Assert.assertTrue(isDisplayed(breadCrumbs),"No aparece el breadcrumb'");
        Assert.assertTrue(isDisplayed(title),"No se muestra el título'");
        Assert.assertTrue(isDisplayed(imagen1erLibro), "No se muestra la imágen del primer libro");
    }
}
