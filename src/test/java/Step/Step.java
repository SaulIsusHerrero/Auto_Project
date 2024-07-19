package Step;

import org.example.Environments;
import org.openqa.selenium.WebDriver;
import page.CookiesPage;
import page.CountryPage;
import page.SuperHomePage;

public class Step {

    protected static WebDriver driver;
    public Step(WebDriver driver) {
        super();
        Step.driver = driver;
    }

    public void goTo(){
       new Environments(driver).goToPro();
    }

    public void manageCookies(){
        CookiesPage cookies = new CookiesPage(driver);

        cookies.verifyCookiesExist()
                .verifyLinkPrivacyExist()
                .verifyBotonAceptarCookiesExist()
                .verifyBotonRechazarOpcionalesExist()
                .verifyBotonConfiguracionCookiesExist()
                .acceptCookies();

    }

    public void manageCountryAndLanguage(){
        CountryPage country = new CountryPage(driver);

        country.openContryCombobox()
                .selectCountry()
                .selectLanguage()
                .clickGoGuardar();

    }

    public void selectWomanProducts(){
        new SuperHomePage(driver).clickWomanButton();
    }
}
