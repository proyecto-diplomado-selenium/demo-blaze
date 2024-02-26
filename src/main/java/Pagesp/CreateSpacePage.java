package Pagesp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateSpacePage extends MainPage {

    private final By inputSpaceName = By.xpath("//cu-create-project-modal//input");
    private final By avatarButton = By.xpath("//cu-create-project-modal//button[@data-pendo='create-project-modal__stage-avatar']");
    private final By statusButton = By.xpath("//cu-create-project-modal//button[@data-test='create-project-modal__statuses-btn']");
    private final By nextButton = By.xpath("//cu-create-project-modal//button");
    private final By clickAppsButton = By.xpath("(//cu-create-project-modal//button)[2]");

    public CreateSpacePage(WebDriver driver) {
        super(driver);
    }

    public CreateSpacePage createSpace(String spaceName) throws InterruptedException {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(driver.findElement(this.inputSpaceName)));
        element.clear();
        element.sendKeys(spaceName);
        WebElement element2 = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(driver.findElement(this.nextButton)));
        element2.click();
        System.out.println("next 1");
        driver.findElement(nextButton).click();
        System.out.println("next 2");
        driver.findElement(avatarButton).click();
        System.out.println("next 3");
        driver.findElement(nextButton).click();
        System.out.println("next 4");
        driver.findElement(statusButton).click();
        System.out.println("next 5");
        driver.findElement(clickAppsButton).click();
        System.out.println("next apps");
        driver.findElement(nextButton).click();
        System.out.println("penultimo apps");
        driver.findElement(nextButton).click();
        System.out.println("create space");
        Thread.sleep(2000);
        return this;
    }
}
