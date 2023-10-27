package cart;

import Pages.CartPage;
import Pages.HomePage;
import Pages.NavbarPage;
import Pages.ProductPage;
import conf.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {
    @Test
    public void validateCartProductTotalPriceTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        NavbarPage navbarPage = new NavbarPage(driver);
        CartPage cartPage = new CartPage(driver);

        homePage.clickOnProductWithName("Samsung galaxy s6");
        productPage.clickOnAddToCart();
        productPage.acceptAlert();
        navbarPage.clickOnCartOption();
        String actual = cartPage.getTotal();
        String expected = "360";

        Assert.assertEquals(actual, expected, "Incorrect total price.");
    }

    @Test
    public void validateCartTwoProductsTotalPriceTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        NavbarPage navbarPage = new NavbarPage(driver);
        CartPage cartPage = new CartPage(driver);

        homePage.clickOnProductWithName("Samsung galaxy s6");
        productPage.clickOnAddToCart();
        productPage.acceptAlert();
        navbarPage.clickOnHomeOption();
        homePage.clickOnProductWithName("Nexus 6");
        productPage.clickOnAddToCart();
        productPage.acceptAlert();
        navbarPage.clickOnCartOption();
        String actual = cartPage.getTotal();
        String expected = "1010";

        Assert.assertEquals(actual, expected, "Incorrect total price.");
    }



}
