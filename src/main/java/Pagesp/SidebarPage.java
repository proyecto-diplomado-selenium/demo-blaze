package Pagesp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SidebarPage extends MainPage{
    private final By spaceText = By.cssSelector(".sidebar__spaces-text");
    private final By addSpaceButton = By.xpath("//button[@class='ng-star-inserted']");
    private final By listItem = By.id("#cdk-drop-list-1");
    private final By listItems = By.xpath("//span[contains(@data-test,'project-row__name__')]");
    private final By listFolderItems = By.xpath("//span[contains(@data-test,'category-row__folder-name__')]");
    private final By listListsItems = By.xpath("//span[contains(@data-test,'category-row__')]");
    private final By loginBtn = By.cssSelector("button[type='submit']");

    public SidebarPage(WebDriver driver) {
        super(driver);
    }

//    @FindBy(css = ".sidebar__spaces-text")
//    private WebElement spaceText;

//    @FindBy(xpath = "//button[@class='ng-star-inserted']")
//    private WebElement addSpaceButton;

//    @FindBy(css = "#login-password-input")
//    private WebElement passwordInput;
//
//    @FindBy(css = "button[type='submit']")
//    private WebElement loginButton;

//    @FindBy(id = "#cdk-drop-list-1")
//    private WebElement listItem;

//    @FindBy(xpath = "//span[contains(@data-test,'project-row__name__')]")
//    private  List<WebElement> listItems;

//    @FindBy(xpath = "//span[contains(@data-test,'category-row__folder-name__')]")
//    private  List<WebElement> listFolderItems;

//    @FindBy(xpath = "//span[contains(@data-test,'category-row__')]")
//    private  List<WebElement> listListsItems;

    private  String itemtName = "(//cu-project-row[contains(.,'%s')]//div[@class='row-actions']//button)[2]";
    private  String spaceSettings = "(//cu-project-row[contains(.,'%s')]//div[@class='row-actions']//button)[1]";
    private String spaceName="//cu-project-row[contains(.,'%s')]";
    private final By createSpaceButton = By.cssSelector("cu-create-project-row.sidebar-create-project-row span.create-project-row__text");

    public SidebarPage clickAddButton() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(spaceText)).perform();
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(this.addSpaceButton));
        element.click();
        return this;
    }

    public SidebarPage clickCreateSpaceButton() throws InterruptedException {
        driver.findElement(createSpaceButton).click();
        return this;
    }

    public List<String> getAllTexts(){
        List<String> texts = new ArrayList<>();

        for(WebElement ele :driver.findElements(listItems)) {
            texts.add(ele.getText());
        }
        return texts;
    }

    public List<String> getAllFolderTexts(){
        List<String> texts = new ArrayList<>();

        for(WebElement ele :driver.findElements(listFolderItems)) {
            texts.add(ele.getText());
        }
        return texts;
    }

    public List<String> getAllListsTexts(){
        List<String> texts = new ArrayList<>();

        for(WebElement ele :driver.findElements(listListsItems)) {
            texts.add(ele.getText());
        }
        return texts;
    }

    public void selectProject(final String value) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(itemtName,value)))).click();
    }

    public void selectSpaceSettings(final String value) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(spaceSettings,value)))).click();
    }

    public void selectSpaceByName(final String name) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(spaceName,name)))).click();
    }
}
