package cart;

import Pages.CartPage;
import Pages.HomePage;
import Pages.NavbarPage;
import Pages.ProductPage;
import conf.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CartTestConfirmProductDeleted extends BaseTest
{
    @Test
    public void validateProductWasDeleted() throws InterruptedException {
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
        List<WebElement> itemsBeforeDelete = cartPage.getItemsInCart();
        cartPage.deleteProductFromCartWithName("Samsung galaxy s7");
        List<WebElement> itemsAfterDelete = cartPage.getItemsInCart();
        if(itemsBeforeDelete == itemsAfterDelete)
        {
            System.out.println("El elemento no ha sido eliminado");
        }
        else
        {
            System.out.println("El elemento ha sido eliminado");
        }

    }


    }
