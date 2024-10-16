package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Locale;

public class TestsCasaDelLibro extends Base {
    //1º Variables
    protected static WebDriver driver;
    //2º Locators
    static By popupCookies = By.xpath("//div[@id='onetrust-group-container']");
    static By configurarCookies = By.xpath("//button[@id='onetrust-pc-btn-handler']");
    static By rechazarCookies = By.xpath("//button[@id='onetrust-reject-all-handler']");
    static By acceptCookiesLocator = By.xpath("//button[@id='onetrust-accept-btn-handler']");
    static By cartModalLocator = By.id("aria-modal-shopcart");
    static By emptyCartMessageLocator = By.xpath("//strong[@class=/'f-size-4 s-7-text/']");
    static By cartButton = By.xpath("//button[@class='btn icon ghost brand-text cesta-btn']");
    static By cartNumber = By.xpath("//span[@class='svelte-wwa3op']");
    static By cestaTitulo =By.xpath("//button[@class='btn ghost icon ml-auto']");
    static By cestaX =By.xpath("//button[@class='btn ghost icon ml-auto']");
    static By cestaVacia = By.xpath("//strong[@class='f-size-4 s-7-text']");
    static By catalogoLocator = By.xpath("//a[normalize-space()='Imprescindibles']");
    static By breadCrumbs = By.xpath("//nav[@aria-label='breadcrumbs']");
    static By title = By.xpath("(//div[@class='compact-product gap-2 px-3 py-2 svelte-9oij4h'])[1]");
    static By imagen1erLibro = By.xpath("//img[@src='https://imagessl0.casadellibro.com/a/l/s1/70/9788401027970.webp']");
    static By addToCartLocator = By.xpath("//button[@class='btn accent f-w-6 svelte-80ls0o']");
    static By tituloProducto = By.xpath("//span[@class='titleProducto mt-2']");
    static By autorProducto = By.xpath("(//div[@class='f-serif s-7-text f-fluid-1'])");
    static By precioProducto = By.xpath("(//p[@class='f-size-6 f-serif f-w-7 no-wrap-text svelte-1c4mio6'])");
    static By precioProductoCarrito = By.xpath("(//span[@class='f-size-4'])");
    static By carritoConProducto_s = By.xpath("(//div[@class='f-size-3 f-serif my-2'])");
    static By botonPagar = By.xpath("(//div[@class='btn accent full-width'])");
    static By buscador = By.xpath("(//div[@class='buscador svelte-10coea1'])");
    static By resultados = By.xpath("//div[contains(@class, 'product-list')]//div[contains(@class, 'product-item')]");
    static By buscadorAbierto = By.xpath("//input[contains(@placeholder, '¿Qué estás buscando?')and not(@aria-hidden)]");
    static By disponibilidadLibrerias = By.xpath("//button[@class='like-a-link accent-text']");
    static By semiModalDisponibilidad = By.xpath("//div[@class='d-flex align-center pl-3 py-1']");
    static By cerrarDisponibilidadLibrerias = By.xpath("//button[@class='btn ghost icon ml-auto']");

    public static boolean isCartOpen() {
        WebElement cartModal = driver.findElement(cartModalLocator);
        String ariaExpanded = cartModal.getAttribute("aria-expanded");
        return "false".equals(ariaExpanded);
    }

    public static boolean isCartEmpty() throws InterruptedException{
    clickAndWait(cartButton);
    //Assert para asegurar que el carrito está vacío.
    Assert.assertTrue(isDisplayed(emptyCartMessageLocator), "El carrito no está vacío");
    return false;
    }

    //3º Constructor
    public TestsCasaDelLibro(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //4º Methods
    public static void cookiesPageElements() throws InterruptedException {
        //Paso 1. Ir a la web.
        System.out.println("Se ha ejecutado el test");
        driver.manage().window().maximize();
        driver.get("https://www.casadellibro.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Paso 2. Comprobar los elementos por defecto.
        String textoConfigurarCookies = "";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        textoConfigurarCookies = driver.findElement(configurarCookies).getText().trim().toLowerCase(Locale.ROOT);
        String textoRechazarCookies = "";
        textoRechazarCookies = driver.findElement(rechazarCookies).getText().trim().toLowerCase(Locale.ROOT);
        String textoAceptarCookiesTexto = "";
        textoAceptarCookiesTexto = driver.findElement(acceptCookiesLocator).getText().trim().toLowerCase(Locale.ROOT);

        Assert.assertTrue(isDisplayed(popupCookies), "No es mostrado el pop up de cookies");
        Assert.assertEquals(textoConfigurarCookies, "configurar cookies", "Error, el texto del botón de configurar cookies no es el correcto");
        Assert.assertEquals(textoAceptarCookiesTexto, "aceptar", "Error, el texto del botón de aceptar todas las cookies no es el correcto");
        Assert.assertEquals(textoRechazarCookies, "rechazar", "Error, el texto del botón de rechazar no es el correcto");
    }
    public static void acceptCookies() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        /** Aceptar pop-up de cookies */
            Thread.sleep(1000);
        click(acceptCookiesLocator);
        Thread.sleep(1000);
        Assert.assertFalse(isDisplayed(popupCookies), "No se ha cerrado el pop up de cookies");
        }

    public static void carritoPageDefaultElements() throws InterruptedException {
        //TODO: Adaptamos este test al carrito de CasaDelLibro
        //(2)@todo clicar en el símbolo del carrito (esto abre la pestaña de la cesta)
        Thread.sleep(1000);
        clickAndWait(cartButton);
        Thread.sleep(2000);

     //1. Assert para comprobar que sale el modal de carrito.
     Assert.assertFalse(isDisplayed(cartModalLocator),"No se muestra el modal del carrito");
     //2. Comprobar que hay un título "Tu cesta"
     Assert.assertTrue(isDisplayed(cestaTitulo), "Titulo 'Tu cesta' se muestra");
     //3. Comprobar que hay un botón "x" para cerrar el modal
     Assert.assertTrue(isDisplayed(cestaX), "Si hay un boton X de Cesta");
     //4. Asegurarnos que aparece el texto "Tu cesta está vacía"
     Assert.assertTrue(isDisplayed(cestaVacia),"Aparece el texto 'Tu cesta esta vacia'");}
    public static void cerrarCarrito() throws InterruptedException {
        click(cestaX);
        Thread.sleep(2000);
        System.out.println("La modal del carrito se ha cerrado con la X");
        //Aseguramos que la modal del carrito se ha cerrado.
        Assert.assertFalse(isDisplayed(cestaX),"Sí se muestra la modal del carrito");
    }
    //SAUL : Test modificado para llegar a un producto de la categoria en el breadcrumbs "Libros en promoción". Y asegurar
    //que hay un producto en dicha categoria.
    public static void acceder_a_Imprescindibles () throws InterruptedException {
        Assert.assertTrue(isDisplayed(catalogoLocator),"No se muestra la categoria Ofertas'");
        clickAndWait(catalogoLocator);
        Thread.sleep(5000);
        Assert.assertTrue(isDisplayed(breadCrumbs),"Sí aparece el breadcrumbs");
        Assert.assertTrue(isDisplayed(title),"No se muestra el título'");
        //Assert para la visibilidad del primero libro - su imágen
        Assert.assertTrue(isDisplayed(imagen1erLibro), "No se muestra la imágen del primer libro");
    }

    public static void checkProductoPage () throws InterruptedException {
        clickAndWait(imagen1erLibro);
        dynamicWait(tituloProducto);
        //Assert se muestra el breadcrumb.
        Assert.assertTrue(isDisplayed(breadCrumbs),"No aparece el breadcrumb'");
        //Assert se muestra el título del producto.
        Assert.assertTrue(isDisplayed(tituloProducto), "No se muestra el título del producto");
        //Assert se muestra el/la autor/a.
        Assert.assertTrue(isDisplayed(autorProducto), "No se muestra el/la autor/a del producto");
        //Assert se muestra el precio del producto.
        Assert.assertTrue(isDisplayed(precioProducto), "No se muestra el precio del producto");
        //Click en Disponibilidad en librerías.
        //clickAndWait(disponibilidadLibrerias);
        Thread.sleep(5000);
        //Aseguramos que se muestra la semi-modal de disponibilidad en librerías.
        //Assert.assertTrue(isDisplayed(semiModalDisponibilidad), "No se muestra la semi-modal de disponibilidad en librerías");
        //Cerramos la semi-modal de disponibilidad en librerías.
        //clickAndWait(cerrarDisponibilidadLibrerias);
    }

    public static void addCarrito () throws InterruptedException {
        clickAndWait(addToCartLocator);
        Thread.sleep(2000);
        //Aseguramos que el producto se ha añadido al carrito.
        Assert.assertTrue(isDisplayed(carritoConProducto_s), "El producto no está en el carrito");
        //Aseguramos que se muestra el precio total del carrito
        Assert.assertTrue(isDisplayed(precioProductoCarrito), "No se muestra el precio total del carrito");
        //Aseguramos que se muestra el botón de pagar
        Assert.assertFalse(isDisplayed(botonPagar), "Sí se muestra el botón de pagar");
        System.out.println("Se ha añadido el producto al carrito y ya no está vacío.");
    }

    public static void isCartNotEmptyHome () throws InterruptedException {
        cerrarCarrito();
        boolean b = driver.findElements(cartNumber).size() > 0;
        //Aseguramos que el carrito no está vacío desde su visión desde la Home.
        Assert.assertTrue(isDisplayed(cartNumber), "El badge muestra un 0, es decir, el carrito está vacío.");
    }

    public static void buscarProducto() throws InterruptedException {
        // Aseguramos que el Buscador se muestra en la Home.
        Assert.assertTrue(isDisplayed(buscador), "El Buscador no es visible");

        // Esperamos que la superposición desaparezca antes de hacer clic
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("overlay")));

        // Hacemos clic en el buscador
        clickAndWait(buscador);

        // Espera hasta que el buscador esté abierto
        wait.until(ExpectedConditions.invisibilityOfElementLocated(buscadorAbierto));
        Assert.assertFalse(isDisplayed(buscadorAbierto), "El buscador está abierto");

        // Espera hasta que el campo de búsqueda esté visible
        try {
            WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(buscadorAbierto));
            searchBox.sendKeys("Actualidad");
            searchBox.submit();
        } catch (TimeoutException e) {
            System.out.println("El campo de búsqueda no es visible después del tiempo de espera.");
        }

        // Esperamos los resultados
        wait.until(ExpectedConditions.visibilityOfElementLocated(resultados));
        WebElement resultadosRecuperados = driver.findElement(resultados);

        // Verificamos si se recuperaron productos
        if (Base.isDisplayed(resultados)) {
            System.out.println("Se ha recuperado al menos 1 producto");
        } else {
            Assert.fail("No se ha recuperado ningún producto");
        }
    }
}