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
    static By cartModalLocator = By.id("aria-modal-shopcart");
    static By emptyCartMessageLocator = By.xpath("//strong[@class=/'f-size-4 s-7-text/']");
    static By cartButton = By.xpath("//button[@class='btn icon ghost brand-text cesta-btn']");
    static By cartNumber = By.xpath("//span[@class='svelte-wwa3op']");
    static By cestaTitulo =By.xpath("//button[@class='btn ghost icon ml-auto']");
    static By cestaX =By.xpath("//button[@class='btn ghost icon ml-auto']");
    static By cestaVacia = By.xpath("//strong[@class='f-size-4 s-7-text']");
    static By catalogoLocator = By.xpath("//a[normalize-space()='Ficción']");
    static By breadccrumbs = By.xpath("//nav[@aria-label='breadcrumbs']");
    static By title = By.xpath("(//div[@class='compact-product gap-2 px-3 py-2 svelte-9oij4h'])[1]");
    static By imagen1erLibro = By.xpath("(//div[@class='compact-product gap-2 px-3 py-2 svelte-9oij4h'])[1]");
    static By addToCartLocator = By.xpath("//button[@class='btn accent f-w-6 svelte-80ls0o']");
    static By tituloProducto = By.xpath("//h1[@class='f-serif balance-title f-fluid-2 f-w-4 mb-2 svelte-xvuu2q']");
    static By autorProducto = By.xpath("(//div[@class='f-serif s-7-text f-fluid-1'])");
    static By precioProducto = By.xpath("(//span[@class='f-w-5 f-size-3'])");
    static By precioProductoCarrito = By.xpath("(//span[@class='f-size-4'])");
    static By carritoConProducto_s = By.xpath("(//div[@class='f-size-3 f-serif my-2'])");
    static By botonPagar = By.xpath("(//div[@class='btn accent full-width'])");

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
    public static boolean isCartEmpty() throws InterruptedException{
        clickAndWait(cartButton);
        //Aseguramos que el carrito está vacío.
        Assert.assertTrue(isDisplayed(emptyCartMessageLocator), "El carrito no está vacío");
        return false;
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
        click(cestaX);
        Thread.sleep(2000);
        System.out.println("La modal del carrito se ha cerrado con la X");
        //Aseguramos que la modal del carrito se ha cerrado.
        Assert.assertFalse(isDisplayed(cestaX),"Sí se muestra la modal del carrito");
    }
    public static void checkFiccion () throws InterruptedException {
        Assert.assertTrue(isDisplayed(catalogoLocator),"No se clickó en categoria ficcion'");
        Assert.assertTrue(isDisplayed(catalogoLocator),"No se clickó en categoria ficcion'");
        Thread.sleep(5000);
        Assert.assertFalse(isDisplayed(breadccrumbs),"Sí aparece el breadcrumbs'");
        Assert.assertTrue(isDisplayed(title),"No se muestra el título'");
        //Assert para la visibilidad del primero libro - su imágen
        Assert.assertTrue(isDisplayed(imagen1erLibro), "No se muestra la imágen del primer libro");
    }

    public static void checkProductoPage () throws InterruptedException {
        clickAndWait(imagen1erLibro);
        //Assert se muestra el breadcrumb.
        Assert.assertTrue(isDisplayed(breadccrumbs),"No aparece el breadcrumb'");
        //Assert se muestra el título del producto.
        Assert.assertTrue(isDisplayed(tituloProducto), "No se muestra el título del producto");
        //Assert se muestra el/la autor/a.
        Assert.assertTrue(isDisplayed(autorProducto), "No se muestra el/la autor/a del producto");
        //Assert se muestra el precio del producto.
        Assert.assertFalse(isDisplayed(precioProducto), "Sí se muestra el precio del producto");
    }

    //TODO 26/9 CREAR 1 TEST CON ASSERTS SOBRE QUE EL PRODUCTO SE HA AÑADIDO AL CARRITO:
    // METER ADDTOCART EN EL TEST
    // METER ASSERTS SOBRE ELEMENTOS DEL CARRITO LLENO (NO OLVIDAR PRECIO NI BOTÓN DE PAGAR)
    // AÑADIR A LA PÁGINA CORRESPONDIENTE
    // LUEGO ASEGURARSE QUE APARECE EN LOS STEPS.

    public static void addCarrito () throws InterruptedException {
        clickAndWait(addToCartLocator);
        Thread.sleep(2000);
        //Aseguramos que el producto se ha añadido al carrito.
        Assert.assertTrue(isDisplayed(carritoConProducto_s), "El producto no está en el carrito");
        //Aseguramos que se muestra el precio total del carrito
        Assert.assertTrue(isDisplayed(precioProductoCarrito), "No se muestra el precio total del carrito");
        //Aseguramos que se muestra el botón de pagar
        Assert.assertFalse(isDisplayed(botonPagar), "Sí se muestra el botón de pagar");
    }

    //TODO Eliminar esta parte y utilizar la que tenemos arriba, previamente hay que copiarla en la página
    // correspondiente antes de los tests y después de los Locators
    //@SAUL : se elimina el método que habia aquí y se sustituye por el isCartEmpty que se añade al test
    //test_4_IsCartEmpty de Test_CasaDelLibro1.


    //TODO 26/9: CONVERTIR ESTO EN UN TEST Y AÑADIRLO A SU PAGE CORRESPONDIENTE
    // LUEGO ASEGURARSE QUE APARECE EN LOS STEPS.
    public static void isCartNotEmptyHome () throws InterruptedException {
        cerrarCarrito();
        boolean b = driver.findElements(cartNumber).size() > 0;
        //Aseguramos que el carrito no está vacío desde su visión desde la Home.
        Assert.assertTrue(isDisplayed(cartNumber), "Se muestra el nº de elementos del carrito desde la Home y no es 0");
    }
}