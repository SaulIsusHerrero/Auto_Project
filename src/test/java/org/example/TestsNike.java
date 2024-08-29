package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Locale;

public class TestsNike extends Base {

    //1º Variables
    protected static WebDriver driver;

    //2º Locators
    static By acceptPreferences = By.xpath("//button[@data-testid='confirm-choice-button']");
    static By cartButton = By.xpath("//a[@class='nds-btn nds-button--icon-only nav-bag-icon css-17i884h ex41m6f0 btn-primary-light']");
    static By cartModalLocator = By.id("aria-modal-shopcart");
    static By emptyCartMessageLocator = By.xpath("//section[@id='aria-modal-shopcart']//div[@class='svg-item'] ");

    //Jorge comprobar cesta 1
    //(3)@todo Categoría: Difícil -- comprobar que se abre la pestaña de la cesta. Pista, hay un localizador (#aria-modal-shopcart) que tiene un atributo cuyo valor cambia cuando aparece la cesta.
    public static boolean isCartOpen(){
        WebElement cartModal = driver.findElement(cartModalLocator);
        String ariaExpanded = cartModal.getAttribute("aria-expanded");
        return "false".equals(ariaExpanded);
    }

    //TODO: Vamos a dejar este método por ahora sin eliminar, quizás nos sirva
    //Jorge 4
    //@todo (comprobar que no hay elementos, la cesta está vacia)
    // Metodo para comprobar si la cesta esta vacia
    public static boolean isCartEmpty(){
        return driver.findElements(emptyCartMessageLocator).size() > 0;
    }


    //3º Constructor
    public TestsNike(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //4º Methods
    public static void cookiesPageElements() throws InterruptedException {
        //Paso 1.Ir a la web
        System.out.println("Se ha ejecutado el primer test");
        driver.manage().window().maximize();
        //driver.get("https://www.bershka.com/");
        driver.get("https://www.nike.com/");

        //Paso 2. Comporbar los elementos por defecto
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        boolean cookiesPopUp = isDisplayed(acceptPreferences);
        Assert.assertTrue(cookiesPopUp, "No es mostrado el pop up de cookies");


        String botonAceptarPreferencias = "";
        botonAceptarPreferencias = driver.findElement(acceptPreferences).getText().trim().toLowerCase(Locale.ROOT);
        Assert.assertEquals(botonAceptarPreferencias, "confirmChoiceCookiesLocator", "Error, el texto del botón de confirmChoiceCookiesLocator no es el correcto");
    }

    // TODO: He separado los tests en Asserts, que luego añadimos a la lista de ejecuones en el @test,
    //  así es más fácil saber dónde falla, y elegimos el orden de las ejeciones
        public static void acceptCookies() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); // TODO: No me gusta esta linea
        /** Aceptar pop-up de cookies */
        click(acceptPreferences);
        Thread.sleep(1000);
        Assert.assertFalse(isDisplayed(acceptPreferences), "No se ha cerrado el pop up de cookies");
        }

        //TODO: A partir de aquí cambiamos de página: PISTA para cuando tengamos que ordenar PO.
public static void carritoPageDefaultElements() throws InterruptedException {
        //TODO: Adaptamos este test al carrito de Nike
        //(2)@todo clicar en el símbolo del carrito (esto abre la pestaña de la cesta)
        Thread.sleep(1000);
        clickAndWait(cartButton);

        //TODO En esta web el carrito NO es una pestaña sino una página: nos simplifica las cosas

    //TODO Aquí comprobaremos que los elementos de la Cesta se ven correctamente y en el estado Vacio, por ejemplo:
    // - La url incluye "Cart"
    // - La cesta está vacía = un texto nos indica "No tienes productos en tu cesta."
    // - Hay un H1 con el texto "Cesta"
    // - Hay un "subtotal" y un "total", estos tienen un valor nulo (summary-subtotal y summary-total no son un número)
    // - Hay 2 botones: Pasar por caja y Paypal, ambos están "Disabled"

}

//TODO: Lo ideal sería crear otro test donde se añada cualquier producto y este cambie todos los elementos del
// carrito: Aparece listado el producto, hay subtotal y total, los botones están "Enabled".
// Para esto tendríamos que crear también la página "Producto" y hacer tests con ello. Por ahora, y para la sesión
// del 29 de agosto vamos a ceñirnos en tener el test de arriba antes de la sesión

    public static void favoritesPageDefaultElements() throws InterruptedException {
// TODO: A diferencia de Bershka, para ver los favoritos hay que estar registrado, si ahcemos clic en el
//  Botón Favoritos (Corazón) llevará a una web de Login -> Dejarlo para el final, seguiremos trabajando
//  en la página Carrito, Por ahora, y para la sesión del 29 de agosto vamos a ceñirnos en tener el test de arriba
//  antes de la sesión
        //        //@SAUL todo verificar que no hay nada en favoritos
//        if(Base.isDisplayed(wLEmpty)){
//            System.out.println("Favoritos está vacío.");
//        }else{
//            Assert.fail("Favoritos no está vacío");
//        }

    }


    //TODO Proximamente: En Nike el botón descubrir podemos cambiarlo por "Novedades y Destacados", abre https://www.nike.com/es/w/nuevo-3n82y
    //        //@todo click en descubrir -- te lleva a descubrir nuevos productos
//        dynamicWait(cartDescubrirButton);
//        if (isDisplayed(cartDescubrirButton)) {
//            System.out.println("Se muestra el botón Descubrir en cesta vacía");
//            clickAndWait(cartDescubrirButton);
//        } else { Assert.fail("No se muestra el botón Descubrir en cesta vacía");
//
    //        //@todo assert para comprobar que se abre la página "New"  (NOta: intentad buscar un localizador que esté presente solo cuando se abre está página)
//        if (isDisplayed(titleCategoryNew)) {
//            System.out.println("Se ha accedido correctamente a la página New");
//            clickAndWait(titleCategoryNew);
//        } else { Assert.fail("No se ha accedido a la página New");
//        }


//TODO Proximamente: Vamos al menú, revisamos  elementos por defecto y clic en una categoría Hombre>Zapatillas
//TODO: Próximamente: Vamos al menú, dejamos el cursor y vemos un sub-menu: elementos por defecto y clic
//TODO Proximamente: Vamos a un producto, revisamos los elementos por defecto y lo añadimos a la cesta

    //TODO: Dejo estos tests de Bershka comentados por ahora.
//        //@todo click en la opción "Jeans"
//        if (isDisplayed(jeansCarruselParrillaNew)) {
//            System.out.println("Se muestra la opción Jeans en el carrusel");
//            clickAndWait(jeansCarruselParrillaNew);
//        } else { Assert.fail("No se muestra la opción Jeans en el carrusel");
//        }
//        //@todo Categoría: Difícil-->comprobar que se activa el botón "jeans" Pista: en el localizador del botón, cuando se clica uno de los atributos también cambia :)
//        //@SAUL todo volver a clicar en el símbolo de la cesta
//        clickAndWait(cartButton);
//        Assert.assertTrue(driver.findElement(wishListButton).isDisplayed(),"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
//        System.out.println("He hecho click en cart button AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
//        //@SAUL todo click en favoritos
//        clickAndWait(wishListButton);
//        //@SAUL todo verificar con assert que estoy en la página de favoritos  (NOta: intentad buscar un localizador que esté presente solo cuando se abre está página)
//        if(Base.isDisplayed(wLPageTitle)){
//            System.out.println("Estamos en Favoritos.");
//        }else{
//            Assert.fail("Error, no estamos en favoritos");
//        }


}