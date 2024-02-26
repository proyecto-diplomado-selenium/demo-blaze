package prueba;

import Pagesp.*;
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


//    @Test(priority = 2)
//    void createSpace() throws InterruptedException {
//        SidebarPage sidebarPage = new SidebarPage(driver);
//        CreateSpacePage createSpacePage = new CreateSpacePage(driver);
//        sidebarPage.clickAddButton();
//        createSpacePage.createSpace("Test space2");
//        System.out.println("TEXT ITEMS: "+sidebarPage.getAllTexts());
//        Assert.assertTrue(sidebarPage.getAllTexts().contains("Test space2"));
//    }

//    @Test(priority = 3)
//    void createFolder() throws InterruptedException {
//        SidebarPage sidebarPage = new SidebarPage(driver);
//        OptionsMenuPage optionsMenuPage = new OptionsMenuPage(driver);
//        CreateFolderPage createFolderPage = new CreateFolderPage(driver);
//        sidebarPage.selectProject("Test space2");
//        optionsMenuPage.selectOption("Carpeta");
//        Thread.sleep(5000);
//        createFolderPage.createSpace("folderTest2");
//        Assert.assertTrue(sidebarPage.getAllFolderTexts().contains("folderTest2"));
//    }

//    @Test(priority = 4)
//    void createList() throws InterruptedException {
////        ExtentTestManager.startTest("createList","NOSE QUE ES");
//        SidebarPage sidebarPage = new SidebarPage(driver);
//        OptionsMenuPage optionsMenuPage = new OptionsMenuPage(driver);
//        CreateListPage createListPage = new CreateListPage(driver);
//        sidebarPage.selectProject("Test space2");
//        optionsMenuPage.selectOption("Lista");
//        Thread.sleep(5000);
//        createListPage.createList("listTest");
//        Assert.assertTrue(sidebarPage.getAllListsTexts().contains("listTest"));
//    }

//    @Test(priority = 5)
//    void createTask() throws InterruptedException {
//
////        ExtentTestManager.startTest("createTask","NOSE QUE ES");
//        SidebarPage sidebarPage = new SidebarPage(driver);
//        OptionsMenuPage optionsMenuPage = new OptionsMenuPage(driver);
//        CreateListPage createListPage = new CreateListPage(driver);
//        ListPage listPage = new ListPage(driver);
//        listPage.createTask("taskTest");
//        Assert.assertTrue(listPage.getAllTasksText().contains("taskTest"));
//    }
}
