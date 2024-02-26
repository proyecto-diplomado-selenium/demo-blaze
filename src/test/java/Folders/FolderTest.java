package Folders;

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
        sidebarPage.clickAddButton();
        createSpacePage.createSpace("Test space2");
        Thread.sleep(2000);
        sidebarPage.selectProject("Test space2");
        optionsMenuPage.selectOption("Carpeta");
        createFolderPage.createSpace("folderTest2");
        Assert.assertTrue(sidebarPage.getAllFolderTexts().contains("folderTest2"));
    }
}
