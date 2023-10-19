package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConfirmationPurchasePage extends BasePage {
    private final By successIcon = By.xpath("//div[contains(@class,'sa-success')]");
    private final By messagePurchase = By.xpath("//div[contains(@class,'sweet-alert')]/h2");
    private final By infoPurchase = By.xpath("//div[contains(@class,'sweet-alert')]/p");
    private final By confirmBtn = By.xpath("//button[contains(@class,'confirm ')]");

    public ConfirmationPurchasePage(WebDriver driver) {
        super(driver);
    }

    public String getMessagePurchase() {
        return driver.findElement(this.messagePurchase).getText();
    }

    public String getInfoPurchase() {
        return driver.findElement(this.infoPurchase).getText();
    }

    public void clickOnOkButton() {
        driver.findElement(this.confirmBtn).click();
    }

    public boolean successIconExist() {
        try {
            WebElement element = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.presenceOfElementLocated(this.successIcon));
            return element.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}
