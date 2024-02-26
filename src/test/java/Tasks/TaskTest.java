package Tasks;

import Pagesp.*;
import conf.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TaskTest extends BaseTest {

    @Test(priority = 1)
    void createFolder() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        CreateSpacePage createSpacePage = new CreateSpacePage(driver);
        SidebarPage sidebarPage = new SidebarPage(driver);
        OptionsMenuPage optionsMenuPage = new OptionsMenuPage(driver);
        CreateFolderPage createFolderPage = new CreateFolderPage(driver);
        CreateListPage createListPage = new CreateListPage(driver);
        ListPage listPage = new ListPage(driver);

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
        listPage.createTask("taskTest");
        Assert.assertTrue(listPage.getAllTasksText().contains("taskTest"));
    }
}
