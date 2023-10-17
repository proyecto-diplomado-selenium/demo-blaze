import Pages.HomePage;
import Pages.LoginPage;
import Pages.NavbarPage;
import Pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest{
    @Test
    public void SelectProductTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);

        homePage.clickOnLaptopsOption();
        homePage.clickOnProductWithName("Sony vaio i5");

        String actual = productPage.getProductTitleName();
        String expected = "Sony vaio i5";

        Assert.assertEquals(actual, expected, "Incorrect name of product.");
    }

    @Test
    public void addProductToCart() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);

        homePage.clickOnProductWithName("Samsung galaxy s6");
        productPage.clickOnAddToCart();

        String actual=  productPage.getAlertText();
        String expected = "Product added";

        Assert.assertEquals(actual, expected, "Incorrect added product to cart.");
    }
}
