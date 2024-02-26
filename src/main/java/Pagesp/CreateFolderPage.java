package Pagesp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.ls.LSOutput;

import java.time.Duration;

public class CreateFolderPage extends MainPage {

    private final By inputFolderName = By.xpath("//div[@class='cu-form__row ng-star-inserted']//input");
    private final By createFolderButton = By.xpath("//button[contains(@class,'cu-btn')]");
    private final By statusButton = By.xpath("//cu-create-project-modal//button[@data-test='create-project-modal__statuses-btn']");
    private final By nextButton = By.xpath("//cu-create-project-modal//button");
    private final By clickAppsButton = By.xpath("(//cu-create-project-modal//button)[2]");
    private final By folderEditor = By.cssSelector("*[data-test='nav-editor__input']");
//    private final By folderSettingsOption = By.xpath("(//cu-category-row[contains(.,'hola')]//div[@class='row-actions']//button)[1]");
    // (//cu-category-row[contains(.,'folderTest2')]//div[@class='row-actions']//button)[2]
    private  String folderSettingsOption = "(//cu-category-row[contains(.,'%s')]//div[@class='row-actions']//button)[1]";
    private String folderName = "//cu-category-row[contains(.,'%s')]";
    public CreateFolderPage(WebDriver driver) {
        super(driver);
    }


    public CreateFolderPage createSpace(String folderName) throws InterruptedException {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(driver.findElement(this.inputFolderName)));
        element.clear();
        element.sendKeys(folderName);
        WebElement element2 = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(driver.findElement(this.createFolderButton)));
        driver.findElement(createFolderButton).click();
        Thread.sleep(2000);
        return this;
    }

    public void editFolder(String folderName) throws InterruptedException {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(this.folderEditor));
        driver.findElement(this.folderEditor).click();
        driver.findElement(this.folderEditor).sendKeys(folderName);
        Actions actions = new Actions(driver);

        // Presionar la tecla ENTER
        actions.sendKeys(driver.findElement(this.folderEditor), Keys.ENTER).perform();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.invisibilityOfElementLocated(this.folderEditor));
    }

    public void selectFolderSettings(final String value) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(folderSettingsOption,value)))).click();
    }

    public void selectFolderByName(final String name) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(folderName,name)))).click();
    }

}
