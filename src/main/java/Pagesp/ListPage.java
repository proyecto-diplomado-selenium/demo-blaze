package Pagesp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ListPage extends MainPage {

    private final By inputTaskName = By.xpath("//cu-task-row-new//input");
    private final By createTaskButton = By.xpath("//cu-task-row-new//button[@data-test='task-row-new__button']");
    private final By cancelTaskButton = By.xpath("//cu-task-row-new//button[@data-test='task-row-new__close']");
    private final By taskListItems = By.xpath("//cu-task-row-main//span");
    private String listName = "//cu-subcategory-row[contains(.,'%s')]";
    private final By listOptions = By.cssSelector("cu-location-menu[class='location-menu'] button");
    private final By listInput = By.cssSelector("*[data-test='editable__input']");
    private final By deleteButton = By.xpath("//div[contains(@class, 'cu-modal__body')]//button[normalize-space()='Eliminar']");
    private final By taskOptions = By.cssSelector("div.cu-task-row__container .cu-task-row-menu");

    public ListPage(WebDriver driver) {
        super(driver);
    }


    public ListPage createTask(String ListName) throws InterruptedException {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(driver.findElement(inputTaskName)));
        element.click();
        element.sendKeys(ListName);
        WebElement element2 = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(driver.findElement(createTaskButton)));
        driver.findElement(createTaskButton).click();
        Thread.sleep(2000);
        return this;
    }

    public List<String> getAllTasksText(){
        List<String> texts = new ArrayList<>();

        for(WebElement ele :driver.findElements(taskListItems)) {
            texts.add(ele.getText());
        }
        return texts;
    }

    public void selectListByName(final String name) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(listName,name)))).click();
    }

    public void clicKListOptions() {
        driver.findElement(this.listOptions).click();
    }

    public void editList(String listName) throws InterruptedException {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(this.listInput));
        driver.findElement(this.listInput).sendKeys(listName);
    }

    public void deleteList() throws InterruptedException {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(driver.findElement(this.deleteButton)));
        driver.findElement(deleteButton).click();
        Thread.sleep(2000);

    }

    public void clicKTaskOptions() {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(this.taskOptions));
        element.click();
    }

    public void editTask(String taskName) throws InterruptedException {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(this.listInput));
        driver.findElement(this.listInput).sendKeys(taskName);
    }
}
