package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Locale;

// Vamos a cambiar la web de los test para ver si evitamos los problemas de esperas, para ello vamos a probar con
// la web de CasaDelLibro. Primero adaptaremos los test que ya tenemos en Bershka a CasaDelLibro, para ello:
// - Tendremos que volver a localizar elementos y añadir nuevos locators
// - Seguiremos los TO-DO en comentarios para ir cambiando los tests
// - Una vez adaptado, adaptaremos la organización de todos los tests para que tengan estructura PageObject

/*"Test 1 : Selecciona país/idioma"*/
public class TestsCasaDelLibro extends Base {
    //@SAUL: todo clean code el código. toda clase de page object tiene que tener declaración de variables, declaración de selectores, constructor,metodos
    //1º Variables
    protected static WebDriver driver;
    //2º Locators
    //TODO DONE: localizar el botón "Confirmar preferencias", lo podemos llamar p.e. "confirmChoiceCookiesLocator"
    static By popupCookies = By.xpath("//div[@id='onetrust-group-container']");
    static By configurarCookies = By.xpath("//button[@id='onetrust-pc-btn-handler']");
    static By rechazarCookies = By.xpath("//button[@id='onetrust-reject-all-handler']");
    static By acceptCookiesLocator = By.xpath("//button[@id='onetrust-accept-btn-handler']");
    static By womanLink = By.xpath("//a[contains(@href, 'woman')]");
    static By cartButton = By.xpath("//button[@class='btn icon ghost brand-text cesta-btn']");
    static By wishListButton = By.xpath("//span[@class='wishlist-button__text']");
    static By wLPageTitle = By.xpath("//h1[@class='top-bar-title-desktop bds-typography-heading-s']");
    static By wLEmpty = By.xpath("//div[@class='empty recommendation-empty-state wishlist-product-grid__empty recommendation-empty-state--carousel']");
    static By cartDescubrirButton = By.xpath("//a[@class='link-text button is-black']");
    static By titleCategoryNew = By.xpath("//h1[@class='top-bar-title-desktop bds-typography-heading-s']");
    static By jeansCarruselParrillaNew = By.xpath("//button[normalize-space()='Jeans']");
    static By cartModalLocator = By.id("aria-modal-shopcart");
    static By emptyCartMessageLocator = By.xpath("//section[@id='aria-modal-shopcart']//div[@class='svg-item'] ");
    static By cestaTitulo =By.xpath("//button[@class='btn ghost icon ml-auto']");
    static By cestaX =By.xpath("//button[@class='btn ghost icon ml-auto']");
    static By cestaVacia = By.xpath("//strong[@class='f-size-4 s-7-text']");
    static By catalogoLocator = By.xpath("//a[normalize-space()='Ficción']");
    static By breadScrum = By.xpath("//nav[@aria-label='breadcrumbs']");
    static By title = By.xpath("(//div[@class='compact-product gap-2 px-3 py-2 svelte-9oij4h'])[1]");
    static By tituloProducto = By.xpath("//h1[@class='f-serif balance-title f-fluid-2 f-w-4 mb-2 svelte-xvuu2q']");
    static By imagen1erLibro = By.xpath("(//div[@class='compact-product gap-2 px-3 py-2 svelte-9oij4h'])[1]");
    static By autorProducto = By.xpath("(//div[@class='f-serif s-7-text f-fluid-1'])");
    static By precioProducto = By.xpath("(//div[@class='info-price d-grid svelte-1c4mio6'])");


    //Jorge comprobar cesta 1
    //(3)@todo Categoría: Difícil -- comprobar que se abre la pestaña de la cesta. Pista, hay un localizador (#aria-modal-shopcart) que tiene un atributo cuyo valor cambia cuando aparece la cesta.
    public static boolean isCartOpen() {
        WebElement cartModal = driver.findElement(cartModalLocator);
        String ariaExpanded = cartModal.getAttribute("aria-expanded");
        return "false".equals(ariaExpanded);
    }

    //TODO: Vamos a dejar este método por ahora sin eliminar, quizás nos sirva
    //Jorge 4
    //@todo (comprobar que no hay elementos, la cesta está vacia)
    // Metodo para comprobar si la cesta esta vacia
    public static boolean isCartEmpty() {
        return driver.findElements(emptyCartMessageLocator).size() > 0;
    }

    //3º Constructor
    public TestsCasaDelLibro(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //4º Methods
    //TODO: Como CasaDelLibro no tiene selector de país en la primera página, vamos solamente a Aceptar Cookies
    public static void cookiesPageElements() throws InterruptedException {
        //Paso 1.Ir a la web
        System.out.println("Se ha ejecutado el primer test");
        driver.manage().window().maximize();
        //driver.get("https://www.bershka.com/");
        driver.get("https://www.casadellibro.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Paso 2. Comprobar los elementos por defecto
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

    
    // TODO: He separado los tests en Asserts, que luego añadimos a la lista de ejecuones en el @test,
    //  así es más fácil saber dónde falla, y elegimos el orden de las ejeciones
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
     Thread.sleep(3000);

// TODO: Deberes 5 de Septiembre:
//  1. Crear un assert para comprobar que sale el modal de carrito
     Assert.assertFalse(isDisplayed(cartModalLocator),"No se muestra el modal del carrito");
//  2. Comprobar que hay un título "Tu cesta"
     Assert.assertTrue(isDisplayed(cestaTitulo), "Titulo 'Tu cesta' se muestra");
//  3. Comprobar que hay un botón "x" para cerrar el modal
     Assert.assertTrue(isDisplayed(cestaX), "Si hay un boton X de Cesta");
//  4. Asegurarnos que aparece el texto "Tu cesta está vacía"
     Assert.assertTrue(isDisplayed(cestaVacia),"Aparece el texto 'Tu cesta esta vacia'");

}

    public static void cerrarCarrito() throws InterruptedException {
// TODO: Deberes 5 de Septiembre 2:
//  1. Crear assert/s para comprobar que se cierra el modal de carrito al pulsar x
        click(cestaX);
        Thread.sleep(2000);
        System.out.println("La modal del carrito se ha cerrado con la X");
        //Assert.assertTrue(isDisplayed(cestaX),"No se ha cerrado la modal del carrito con X ");
    }

    //TODO 19 de Septiembre 1: "Elementos por defecto página de Ficción" --> Añadir Página CATALOGO
    // 1. Crear una nueva página con un nuevo test (public static void XXX () throws InterruptedException {...}) y añadirlo
    // tanto aquí como en la página, como en STEP. Si creamos una página nueva habrá que añadirla a MyFirstTest (carpeta test)
    // 2. Llegar a la página de Ficción
    // 3. Comprobar la existencia de 4 elementos que demuestren la carga de la página con asserts,
    // uno de los elementos tiene que ser el breadcrumb

    public static void catalogoPage() throws InterruptedException{
        Thread.sleep(5000);
        clickAndWait(catalogoLocator);
        Thread.sleep(5000);
    }

    public static void checkFiccion () throws InterruptedException {
        Assert.assertTrue(isDisplayed(catalogoLocator),"No se clickó en categoria ficcion'");
        Assert.assertTrue(isDisplayed(breadScrum),"No aparece el breadcrumb'");
        Assert.assertTrue(isDisplayed(title),"No se muestra el título'");
        //Assert para la visibilidad del primero libro - su imágen
        Assert.assertTrue(isDisplayed(imagen1erLibro), "No se muestra la imágen del primer libro");
    }

    //TODO 19 de Septiembre 2: "Elementos por defecto página de Producto" --> Añadir Página PRODUCTO
    // 1. Crear un nuevo test (public static void XXX () throws InterruptedException {...}) y añadirlo
    // tanto aquí como Test_CasaDelLibro1 dentro del Try para poder ejecutarlo
    // 2. Llegar a la página de FICCIÓN y luego llegar a la página de un libro
    // 3. Comprobar la existencia de 4 elementos que demuestren la carga de la página de Producto con asserts.
    // uno de los elementos tiene que ser el breadcrumb

    public static void productoPage() throws InterruptedException{
        Thread.sleep(5000);
        clickAndWait(imagen1erLibro);
        Thread.sleep(5000);
    }

    public static void checkProductoPage () throws InterruptedException {
        //Assert se muestra el breadcrumb.
        Assert.assertTrue(isDisplayed(breadScrum),"No aparece el breadcrumb'");
        //Assert se muestra el título del producto.
        Assert.assertTrue(isDisplayed(tituloProducto), "No se muestra el título del producto");
        //Assert se muestra el/la autor/a.
        Assert.assertTrue(isDisplayed(autorProducto), "No se muestra el/la autor/a del producto");
        //Assert se muestra el precio del producto.
        Assert.assertTrue(isDisplayed(precioProducto), "No se muestra el precio del producto");
    }

    //TODO 19 de Septiembre 3: "Añadir un producto al carrito"
    // 1. Crear un nuevo test
    // 2. Llegar a la página de un producto y hacer clic en el botón de "Añadir a la cesta"
    // 3. Comprobar que sale el modal del carrito (si tarda, meted un sleep) y que éste está lleno a diferencia
    // del test de los "Elementos por defecto carrito"


    //TODO EXTRA PLUS: Crear un test para cerrar el carrito lleno y asegurarse que en el icono aparece un
    // número diferente a cero.

}