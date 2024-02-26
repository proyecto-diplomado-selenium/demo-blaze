package Pagesp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DeleteSpacePage extends MainPage {

    private final By deleteSpaceName = By.cssSelector(".cu-modal__body input");
    private final By deleteButton = By.xpath("//div[contains(@class, 'cu-modal__body')]//button[normalize-space()='Eliminar']");

    public DeleteSpacePage(WebDriver driver) {
        super(driver);
    }

    public DeleteSpacePage deleteSpace(String spaceName) throws InterruptedException {

        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(driver.findElement(this.deleteSpaceName)));

        element.clear();
        element.sendKeys(spaceName);

        WebElement element2 = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(driver.findElement(this.deleteButton)));
        driver.findElement(deleteButton).click();
        Thread.sleep(2000);
        return this;
    }
}
