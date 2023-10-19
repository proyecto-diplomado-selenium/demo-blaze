import Pages.CartPage;
import Pages.HomePage;
import Pages.NavbarPage;
import Pages.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CartTestNegative extends BaseTest
{
    @Test
    public void validateCartProductTotalPriceNegativeTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        NavbarPage navbarPage = new NavbarPage(driver);
        CartPage cartPage = new CartPage(driver);

        homePage.clickOnProductWithName("Nexus 6");
        productPage.clickOnAddToCart();
        productPage.acceptAlert();
        navbarPage.clickOnHomeOption();
        homePage.clickOnProductWithName("Samsung galaxy s7");
        productPage.clickOnAddToCart();
        productPage.acceptAlert();
        navbarPage.clickOnCartOption();
        cartPage.deleteProductFromCartWithName("Samsung galaxy s7");
        String actual = cartPage.waitForSpecificProductPrice("650");
        String expected = "650";
        Assert.assertEquals(actual, expected, "Incorrect total price.");
    }
}
