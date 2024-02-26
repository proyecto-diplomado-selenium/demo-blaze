package ui.Spaces;

import Pagesp.*;
import conf.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SpaceTest extends BaseTest {




    @Test(priority = 1)
    void createSpace() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        SidebarPage sidebarPage = new SidebarPage(driver);
        CreateSpacePage createSpacePage = new CreateSpacePage(driver);
        OptionsMenuPage optionsMenuPage = new OptionsMenuPage(driver);
        DeleteSpacePage deleteSpacePage = new DeleteSpacePage(driver);
        loginPage.login("juampi7237@gmail.com", "JPG123456jpg");
//        sidebarPage.clickAddButton();
        sidebarPage.clickCreateSpaceButton();
        createSpacePage.createSpace("Test space");
        System.out.println("TEXT ITEMS: " + sidebarPage.getAllTexts());
        Assert.assertTrue(sidebarPage.getAllTexts().contains("Test space"));
        sidebarPage.selectSpaceSettings("Test space");
        optionsMenuPage.settingOption("Eliminar");
        deleteSpacePage.deleteSpace("Test space");
        Assert.assertTrue(!sidebarPage.getAllTexts().contains("Test space"));
    }

    @Test(priority = 2)
    void updateSpace() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        SidebarPage sidebarPage = new SidebarPage(driver);
        CreateSpacePage createSpacePage = new CreateSpacePage(driver);
        OptionsMenuPage optionsMenuPage = new OptionsMenuPage(driver);
        DeleteSpacePage deleteSpacePage = new DeleteSpacePage(driver);
        UpdateSpacePage updateSpacePage = new UpdateSpacePage(driver);
        loginPage.login("juampi7237@gmail.com", "JPG123456jpg");
//        sidebarPage.clickAddButton();
        sidebarPage.clickCreateSpaceButton();
        createSpacePage.createSpace("Test space 1");
        System.out.println("TEXT ITEMS: " + sidebarPage.getAllTexts());
        Assert.assertTrue(sidebarPage.getAllTexts().contains("Test space 1"));
        sidebarPage.selectSpaceSettings("Test space 1");
        optionsMenuPage.settingOption("Cambiar nombre");
        updateSpacePage.updateSpace("Test space update");
        sidebarPage.selectSpaceSettings("Test space update");
        optionsMenuPage.settingOption("Eliminar");
        deleteSpacePage.deleteSpace("Test space update");
        Assert.assertTrue(!sidebarPage.getAllTexts().contains("Test space update"));
    }

    @Test(priority = 3)
    void deleteSpace() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        SidebarPage sidebarPage = new SidebarPage(driver);
        CreateSpacePage createSpacePage = new CreateSpacePage(driver);
        OptionsMenuPage optionsMenuPage = new OptionsMenuPage(driver);
        DeleteSpacePage deleteSpacePage = new DeleteSpacePage(driver);
        loginPage.login("juampi7237@gmail.com", "JPG123456jpg");
//        sidebarPage.clickAddButton();
        sidebarPage.clickCreateSpaceButton();
        createSpacePage.createSpace("Space-Test 2");
        System.out.println("TEXT ITEMS: " + sidebarPage.getAllTexts());
        Assert.assertTrue(sidebarPage.getAllTexts().contains("Space-Test 2"));
        sidebarPage.selectSpaceSettings("Space-Test 2");
        optionsMenuPage.settingOption("Eliminar");
        deleteSpacePage.deleteSpace("Space-Test 2");
        Assert.assertTrue(!sidebarPage.getAllTexts().contains("Space-Test 2"));
    }
}
