package Pagesp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UpdateSpacePage extends MainPage {

    private final By updateSpaceName = By.cssSelector(".cu-modal__body input");
    private final By saveButton = By.xpath("//div[contains(@class, 'cu-modal__body')]//button[normalize-space()='Guardar']");

    public UpdateSpacePage(WebDriver driver) {
        super(driver);
    }

    public UpdateSpacePage updateSpace(String spaceName) throws InterruptedException {

        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(driver.findElement(this.updateSpaceName)));

        element.clear();
        element.sendKeys(spaceName);

        WebElement element2 = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(driver.findElement(this.saveButton)));
        driver.findElement(saveButton).click();
        Thread.sleep(2000);
        return this;
    }
}
