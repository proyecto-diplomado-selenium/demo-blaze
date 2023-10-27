package purchase;

import Pages.*;
import conf.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PurchaseTest extends BaseTest {
    @Test
    public void validateSuccessPurchaseTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        NavbarPage navbarPage = new NavbarPage(driver);
        CartPage cartPage = new CartPage(driver);
        PlaceOrderPage placeOrderPage = new PlaceOrderPage(driver);
        ConfirmationPurchasePage confirmationPurchasePage = new ConfirmationPurchasePage(driver);

        homePage.clickOnLaptopsOption();
        homePage.clickOnProductWithName("Sony vaio i5");
        productPage.clickOnAddToCart();
        productPage.acceptAlert();

        navbarPage.clickOnCartOption();
        cartPage.clickOnPlaceOrderButton();

        placeOrderPage.fillPurchaseInformation("userTes","Bolivia","La Paz","1234567","Agosto","2023");

        Assert.assertTrue(confirmationPurchasePage.successIconExist(), "Success icon does not exist.");
    }

    @Test
    public void validateSuccessPurchaseMessageTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        NavbarPage navbarPage = new NavbarPage(driver);
        CartPage cartPage = new CartPage(driver);
        PlaceOrderPage placeOrderPage = new PlaceOrderPage(driver);
        ConfirmationPurchasePage confirmationPurchasePage = new ConfirmationPurchasePage(driver);

        homePage.clickOnLaptopsOption();
        homePage.clickOnProductWithName("Sony vaio i5");
        productPage.clickOnAddToCart();
        productPage.acceptAlert();

        navbarPage.clickOnCartOption();
        cartPage.clickOnPlaceOrderButton();

        placeOrderPage.fillPurchaseInformation("userTes","Bolivia","La Paz","1234567","Agosto","2023");

        String actualMessage =confirmationPurchasePage.getMessagePurchase();
        String expectedMessage = "Thank you for your purchase!";

        Assert.assertEquals(actualMessage,expectedMessage,"Success message does not exist.");
    }
}
