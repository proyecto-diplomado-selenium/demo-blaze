package cart;

import Pages.CartPage;
import Pages.HomePage;
import Pages.NavbarPage;
import Pages.ProductPage;
import conf.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class CartTestConfirmTotalPriceAfterDelete extends BaseTest {

    @Test
    public void validateTotalPriceAfterDelete() throws InterruptedException {
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
        String TotalBeforeDelete = cartPage.getTotal();
        cartPage.deleteProductFromCartWithName("Samsung galaxy s7");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String TotalAfterDelete = cartPage.getTotal();
        if(TotalBeforeDelete == TotalAfterDelete)
        {
            System.out.println("El total no ha sido actualizado y es" + TotalBeforeDelete);
        }
        else
        {
            System.out.println("El total  ha sido actualizado y es " + TotalAfterDelete);
        }


    }
}
