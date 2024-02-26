package ui.Folders;

import Pagesp.*;
import conf.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FolderTest extends BaseTest {
    @Test(priority = 1)
    void createFolder() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        CreateSpacePage createSpacePage = new CreateSpacePage(driver);
        SidebarPage sidebarPage = new SidebarPage(driver);
        OptionsMenuPage optionsMenuPage = new OptionsMenuPage(driver);
        CreateFolderPage createFolderPage = new CreateFolderPage(driver);
        loginPage.login("juampi7237@gmail.com", "JPG123456jpg");
        Thread.sleep(2000);
//        sidebarPage.clickAddButton();
        sidebarPage.clickCreateSpaceButton();
        createSpacePage.createSpace("Test space2");
        Thread.sleep(2000);
        sidebarPage.selectProject("Test space2");
        optionsMenuPage.selectOption("Carpeta");
        createFolderPage.createSpace("folderTest2");
        Assert.assertTrue(sidebarPage.getAllFolderTexts().contains("folderTest2"));
    }

    @Test(priority = 2)
    void updateFolder() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        SidebarPage sidebarPage = new SidebarPage(driver);
        OptionsMenuPage optionsMenuPage = new OptionsMenuPage(driver);
        CreateFolderPage createFolderPage = new CreateFolderPage(driver);
        loginPage.login("juampi7237@gmail.com", "JPG123456jpg");
        sidebarPage.selectSpaceByName("Test space2");
        createFolderPage.selectFolderByName("folderTest2");
        createFolderPage.selectFolderSettings("folderTest2");
        Thread.sleep(2000);
        optionsMenuPage.settingOption("Cambiar nombre");
        Thread.sleep(2000);
        createFolderPage.editFolder("123");
        Thread.sleep(2000);
        Assert.assertTrue(sidebarPage.getAllFolderTexts().contains("folderTest2123"));
    }

    @Test(priority = 3)
    void deleteFolder() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        SidebarPage sidebarPage = new SidebarPage(driver);
        DeleteSpacePage deleteSpacePage = new DeleteSpacePage(driver);
        OptionsMenuPage optionsMenuPage = new OptionsMenuPage(driver);
        CreateFolderPage createFolderPage = new CreateFolderPage(driver);
        loginPage.login("juampi7237@gmail.com", "JPG123456jpg");
        sidebarPage.selectSpaceByName("Test space2");
        createFolderPage.selectFolderByName("folderTest2123");
        createFolderPage.selectFolderSettings("folderTest2123");
        optionsMenuPage.settingOption("Eliminar");
        deleteSpacePage.deleteSpace("folderTest2123");
        Assert.assertTrue(!sidebarPage.getAllFolderTexts().contains("folderTest2123"));
    }

    @Test(priority = 4)
    void deleteSpace() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        SidebarPage sidebarPage = new SidebarPage(driver);
        OptionsMenuPage optionsMenuPage = new OptionsMenuPage(driver);
        DeleteSpacePage deleteSpacePage = new DeleteSpacePage(driver);
        loginPage.login("juampi7237@gmail.com", "JPG123456jpg");
        sidebarPage.selectSpaceSettings("Test space2");
        optionsMenuPage.settingOption("Eliminar");
        deleteSpacePage.deleteSpace("Test space2");
        Assert.assertTrue(!sidebarPage.getAllTexts().contains("Test space2"));
    }
}
