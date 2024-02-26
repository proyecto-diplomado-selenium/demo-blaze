package ui.prueba;

import Pagesp.LoginPage;
import Pagesp.ProjectPage;
import conf.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass1 extends BaseTest {


    @Test(priority = 1)
    void loginWithRightCredentials(){
        LoginPage loginPage = new LoginPage(driver);
        ProjectPage projectPage = new ProjectPage(driver);
        loginPage.login("juampi7237@gmail.com","JPG123456jpg");
        String username = projectPage.getUserName();
        Assert.assertEquals("Juan Pablo Gonzales's Workspace",  username);
    }

    @Test(priority = 2)
    void loginWithBadCredentials() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        ProjectPage projectPage = new ProjectPage(driver);
        loginPage.login("juampi7237@gmail.com","wrongPassword123");
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertEquals("Has introducido una contraseña incorrecta para este correo electrónico.",  errorMessage);
    }


}
