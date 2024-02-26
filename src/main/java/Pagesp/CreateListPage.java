package Pagesp;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateListPage extends MainPage {

    private final By inputListName = By.cssSelector("div.simple-input-modal__body > input");
    private final By createListButton = By.cssSelector(".simple-input-modal__button.simple-input-modal__button-submit");
    private final By cancelListButton = By.cssSelector(".simple-input-modal__button.simple-input-modal__button-cancel");

    public CreateListPage(WebDriver driver) {
        super(driver);
    }

//    @FindBy(css = ".simple-input-modal__body > input")
//    private WebElement inputListName;

//    @FindBy(css = ".simple-input-modal__button.simple-input-modal__button-submit")
//    private WebElement createListButton;

//    @FindBy(css = ".simple-input-modal__button.simple-input-modal__button-cancel")
//    private WebElement cancelListButton;

    public CreateListPage createList(String ListName) throws InterruptedException {
        System.out.print("LOCATOR: "+this.inputListName);

        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(driver.findElement(this.inputListName)));

        System.out.print("ELEMENT: "+element);
        element.clear();
        element.sendKeys(ListName);
        WebElement element2 = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(driver.findElement(this.createListButton)));
        driver.findElement(createListButton).click();
        Thread.sleep(2000);
        return this;
    }
}
