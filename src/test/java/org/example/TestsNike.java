package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class TestsNike extends Base {

    //Variables
    protected static WebDriver driver;
    //Locators
    static By acceptPreferences = By.xpath("//button[@data-testid='confirm-choice-button']");
    static By cartButton = By.xpath("//a[@class='nds-btn nds-button--icon-only nav-bag-icon css-17i884h ex41m6f0 btn-primary-light']");
    static By emptyCartMessageLocator = By.xpath("//section[@id='aria-modal-shopcart']//div[@class='svg-item'] ");

    //Constructor
    public TestsNike(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    // Methods : Accept cookies
    public static void acceptCookies() throws InterruptedException {
        /** Aceptar pop-up de cookies */
        click(acceptPreferences);
        Thread.sleep(1000);
        Assert.assertFalse(isDisplayed(acceptPreferences), "No se ha cerrado el pop up de cookies");
        }

    //TODO: A partir de aquí cambiamos de página: PISTA para cuando tengamos que ordenar PO.
    public static void carritoPageDefaultElements() throws InterruptedException {
        //TODO: Adaptamos este test al carrito de Nike
        //(2)@todo clicar en el símbolo del carrito (esto abre la pestaña de la cesta)
        //Thread.sleep(1000);
        //clickAndWait(cartButton);

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

    public static void cookiesPageElements() {
    }

    public void openCart() {
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