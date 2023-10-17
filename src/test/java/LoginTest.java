import Pages.LoginPage;
import Pages.NavbarPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void loginSuccessTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        NavbarPage navbarPage = new NavbarPage(driver);
        navbarPage.clickOnLoginOption();
        loginPage.login("random01", "random01");

        String actual = navbarPage.getNameUserOfUser();
        System.out.println(actual);

        Assert.assertEquals(actual, "Welcome random01", "Incorrect name of user.");
        System.out.println("Test passed");
    }
}
