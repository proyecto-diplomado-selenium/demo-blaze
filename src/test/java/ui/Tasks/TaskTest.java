package ui.Tasks;

import Pagesp.*;
import conf.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TaskTest extends BaseTest {

    @Test(priority = 1)
    void createTask() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        CreateSpacePage createSpacePage = new CreateSpacePage(driver);
        SidebarPage sidebarPage = new SidebarPage(driver);
        OptionsMenuPage optionsMenuPage = new OptionsMenuPage(driver);
        CreateListPage createListPage = new CreateListPage(driver);
        ListPage listPage = new ListPage(driver);

        loginPage.login("juampi7237@gmail.com", "JPG123456jpg");
//        sidebarPage.clickAddButton();
        sidebarPage.clickCreateSpaceButton();
        createSpacePage.createSpace("Test space task");
        sidebarPage.selectProject("Test space task");
        optionsMenuPage.selectOption("Lista");
        createListPage.createList("listTest");
        listPage.createTask("taskTest");
        Assert.assertTrue(listPage.getAllTasksText().contains("taskTest"));
    }

    @Test(priority = 2)
    void updateTask() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        SidebarPage sidebarPage = new SidebarPage(driver);
        OptionsMenuPage optionsMenuPage = new OptionsMenuPage(driver);
        ListPage listPage = new ListPage(driver);
        loginPage.login("juampi7237@gmail.com", "JPG123456jpg");
        sidebarPage.selectSpaceByName("Test space task");
        listPage.selectListByName("listTest");
        listPage.clicKTaskOptions();
        optionsMenuPage.settingOption("Cambiar nombre");
        listPage.editTask("123");
        listPage.selectListByName("listTest");
        Thread.sleep(1000);
        Assert.assertTrue(listPage.getAllTasksText().contains("taskTest123"));
    }

    @Test(priority = 3)
    void deleteTask() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        SidebarPage sidebarPage = new SidebarPage(driver);
        DeleteSpacePage deleteSpacePage = new DeleteSpacePage(driver);
        OptionsMenuPage optionsMenuPage = new OptionsMenuPage(driver);
        ListPage listPage = new ListPage(driver);
        loginPage.login("juampi7237@gmail.com", "JPG123456jpg");
        sidebarPage.selectSpaceByName("Test space task");
        listPage.selectListByName("listTest");
        listPage.clicKTaskOptions();
        optionsMenuPage.settingOption("Eliminar");
        Assert.assertTrue(!listPage.getAllTasksText().contains("taskTest123"));
    }

    @Test(priority = 4)
    void deleteSpace() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        SidebarPage sidebarPage = new SidebarPage(driver);
        OptionsMenuPage optionsMenuPage = new OptionsMenuPage(driver);
        DeleteSpacePage deleteSpacePage = new DeleteSpacePage(driver);
        loginPage.login("juampi7237@gmail.com", "JPG123456jpg");
        sidebarPage.selectSpaceSettings("Test space task");
        optionsMenuPage.settingOption("Eliminar");
        deleteSpacePage.deleteSpace("Test space task");
        Assert.assertTrue(!sidebarPage.getAllTexts().contains("Test space task"));
    }
}
