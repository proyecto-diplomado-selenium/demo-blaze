package ui.lists;

import Pagesp.*;
import conf.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ListTest extends BaseTest {
    @Test(priority = 1)
    void createLista() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        CreateSpacePage createSpacePage = new CreateSpacePage(driver);
        SidebarPage sidebarPage = new SidebarPage(driver);
        OptionsMenuPage optionsMenuPage = new OptionsMenuPage(driver);
        CreateListPage createListPage = new CreateListPage(driver);
        loginPage.login("juampi7237@gmail.com", "JPG123456jpg");
//        sidebarPage.clickAddButton();
        sidebarPage.clickCreateSpaceButton();
        createSpacePage.createSpace("Test space list");
        sidebarPage.selectProject("Test space list");
        optionsMenuPage.selectOption("Lista");
        createListPage.createList("listTest");
        Assert.assertTrue(sidebarPage.getAllListsTexts().contains("listTest"));
    }

    @Test(priority = 2)
    void updateLista() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        SidebarPage sidebarPage = new SidebarPage(driver);
        OptionsMenuPage optionsMenuPage = new OptionsMenuPage(driver);
        ListPage listPage = new ListPage(driver);
        loginPage.login("juampi7237@gmail.com", "JPG123456jpg");
        sidebarPage.selectSpaceByName("Test space list");
        listPage.selectListByName("listTest");
        listPage.clicKListOptions();
        Thread.sleep(2000);
        optionsMenuPage.settingOption("Cambiar nombre");
        Thread.sleep(2000);
        listPage.editList("123");
        sidebarPage.selectSpaceByName("Test space list");
        Thread.sleep(2000);
        Assert.assertTrue(sidebarPage.getAllListsTexts().contains("listTest123"));
    }

    @Test(priority = 3)
    void deleteList() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        SidebarPage sidebarPage = new SidebarPage(driver);
        DeleteSpacePage deleteSpacePage = new DeleteSpacePage(driver);
        OptionsMenuPage optionsMenuPage = new OptionsMenuPage(driver);
        ListPage listPage = new ListPage(driver);
        loginPage.login("juampi7237@gmail.com", "JPG123456jpg");
        sidebarPage.selectSpaceByName("Test space list");
        listPage.selectListByName("listTest123");
        listPage.clicKListOptions();
        optionsMenuPage.settingOption("Eliminar");
        listPage.deleteList();
        Assert.assertTrue(!sidebarPage.getAllListsTexts().contains("listTest123"));
    }

    @Test(priority = 4)
    void deleteSpace() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        SidebarPage sidebarPage = new SidebarPage(driver);
        OptionsMenuPage optionsMenuPage = new OptionsMenuPage(driver);
        DeleteSpacePage deleteSpacePage = new DeleteSpacePage(driver);
        loginPage.login("juampi7237@gmail.com", "JPG123456jpg");
        sidebarPage.selectSpaceSettings("Test space list");
        optionsMenuPage.settingOption("Eliminar");
        deleteSpacePage.deleteSpace("Test space list");
        Assert.assertTrue(!sidebarPage.getAllTexts().contains("Test space list"));
    }
}
