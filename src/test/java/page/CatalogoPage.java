package page;
import org.example.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CatalogoPage extends Base {

    //1º Declare variables
    protected static WebDriver driver;

    // Locators
    static By catalogoOfertasLocator = By.xpath("//a[normalize-space()='Ofertas']");
    static By breadCrumbs = By.xpath("//nav[@aria-label='breadcrumbs']");
    static By title = By.xpath("(//div[@class='compact-product gap-2 px-3 py-2 svelte-9oij4h'])[1]");
    static By imagen1erLibro = By.xpath("(//div[@class='compact-product gap-2 px-3 py-2 svelte-9oij4h'])[1]");
    static By imprescindiblesLocator = By.xpath("//a[normalize-space()='Imprescindibles']");
    static By catalogoLocator = By.xpath("//a[normalize-space()='Ofertas']");
    static By buscador = By.xpath("(//div[@class='buscador svelte-10coea1'])");
    static By buscadorAbierto = By.xpath("(//h1[@class='x-title4-sm x-title4 x-flex x-h-32 x-items-center x-pt-16 x-pl-24 x-uppercase x-text-neutral-90 desktop:x-pl-0 desktop:x-pt-0'])");

    // Constructor
    public CatalogoPage(WebDriver driver) {
        super(driver);

    }

    // Tests terminados en asserts
    public static void checkOfertas () throws InterruptedException {

        Assert.assertTrue(isDisplayed(catalogoLocator),"No se muestra la categoria Ofertas'");
        Thread.sleep(5000);
        Assert.assertFalse(isDisplayed(breadCrumbs),"Sí aparece el breadcrumbs");
        Assert.assertTrue(isDisplayed(title),"No se muestra el título'");
        //Assert para la visibilidad del primero libro - su imágen
        Assert.assertTrue(isDisplayed(imagen1erLibro), "No se muestra la imágen del primer libro");
    }

    public static void buscarProducto () throws InterruptedException{
        //Aseguramos que el Buscador se muestra en la Home.
        Assert.assertTrue(isDisplayed(buscador), "El Buscador no es visible");
        clickAndWait(buscador);
        Thread.sleep(2000);
        //Aseguramos que el Buscador se ha abierto.
        Assert.assertTrue(isDisplayed(buscadorAbierto));
        //Realizamos una búsqueda por ejemplo : "Actualidad"
        //Aseguramos que se recupera algún producto
    }
}
