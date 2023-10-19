import Pages.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class PlaceOrderTest extends BaseTest
{
    @Test
        public void PlacingOrder() throws InterruptedException {
            HomePage homePage = new HomePage(driver);
            ProductPage productPage = new ProductPage(driver);
            NavbarPage navbarPage = new NavbarPage(driver);
            CartPage cartPage = new CartPage(driver);
            PlaceOrderPage placeOrderPage = new PlaceOrderPage(driver);

            homePage.clickOnProductWithName("Nexus 6");
            productPage.clickOnAddToCart();
            productPage.acceptAlert();
            navbarPage.clickOnHomeOption();
            homePage.clickOnProductWithName("Samsung galaxy s7");
            productPage.clickOnAddToCart();
            productPage.acceptAlert();
            navbarPage.clickOnCartOption();
            cartPage.clickOnPlaceOrderButton();
            placeOrderPage.enterName("Alan Brito Delgado");
            placeOrderPage.enterCountry("Bolivia");
            placeOrderPage.enterCity("La Paz");
            placeOrderPage.enterCard("8000800080008000");
            placeOrderPage.enterMonth("October");
            placeOrderPage.enterYear("2023");
            placeOrderPage.clickOnPurchaseButton();

        }
    }
