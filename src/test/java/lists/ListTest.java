package lists;

import Pagesp.*;
import conf.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ListTest extends BaseTest {
    @Test(priority = 1)
    void createFolder() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        CreateSpacePage createSpacePage = new CreateSpacePage(driver);
        SidebarPage sidebarPage = new SidebarPage(driver);
        OptionsMenuPage optionsMenuPage = new OptionsMenuPage(driver);
        CreateFolderPage createFolderPage = new CreateFolderPage(driver);
        CreateListPage createListPage = new CreateListPage(driver);
        loginPage.login("juampi7237@gmail.com", "JPG123456jpg");
        Thread.sleep(2000);
        sidebarPage.clickAddButton();
        createSpacePage.createSpace("Test space2");
        Thread.sleep(2000);
        sidebarPage.selectProject("Test space2");
        optionsMenuPage.selectOption("Lista");
        Thread.sleep(1000);
        createListPage.createList("listTest");
        Thread.sleep(2000);
        Assert.assertTrue(sidebarPage.getAllListsTexts().contains("listTest"));
    }
}
