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
        ConfirmationPurchasePage confirmationPurchasePage = new ConfirmationPurchasePage(driver);

            homePage.clickOnProductWithName("Nexus 6");
            productPage.clickOnAddToCart();
            productPage.acceptAlert();
            navbarPage.clickOnHomeOption();
            homePage.clickOnProductWithName("Samsung galaxy s7");
            productPage.clickOnAddToCart();
            productPage.acceptAlert();
            navbarPage.clickOnCartOption();
            cartPage.clickOnPlaceOrderButton();
            placeOrderPage.fillPurchaseInformation("userTest","Bolivia","La Paz","1234567","Agosto","2023");

            String actualMessage =confirmationPurchasePage.getMessagePurchase();
            String expectedMessage = "Thank you for your purchase!";

            Assert.assertEquals(actualMessage,expectedMessage,"Success message does not exist.");

        }
    }
