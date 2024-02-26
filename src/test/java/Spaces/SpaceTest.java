package Spaces;

import Pagesp.CreateSpacePage;
import Pagesp.LoginPage;
import Pagesp.ProjectPage;
import Pagesp.SidebarPage;
import conf.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SpaceTest extends BaseTest {
    @Test(priority = 1)
    void createSpace() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        SidebarPage sidebarPage = new SidebarPage(driver);
        CreateSpacePage createSpacePage = new CreateSpacePage(driver);
        loginPage.login("juampi7237@gmail.com","JPG123456jpg");
        sidebarPage.clickAddButton();
        createSpacePage.createSpace("Test space2");
        System.out.println("TEXT ITEMS: "+sidebarPage.getAllTexts());
        Assert.assertTrue(sidebarPage.getAllTexts().contains("Test space2"));
    }
}
