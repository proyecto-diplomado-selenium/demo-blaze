package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {
    private final By phones = By.xpath("//div[@class='list-group']//a[contains(.,'Phones')]");
    private final By laptops = By.xpath("//div[@class='list-group']//a[contains(.,'Laptops')]");
    private final By monitors = By.xpath("//div[@class='list-group']//a[contains(.,'Monitors')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnPhonesOption() {
        driver.findElement(this.phones).click();
    }

    public void clickOnLaptopsOption() {
        driver.findElement(this.laptops).click();
    }

    public void clickOnMonitorsOption() {
        driver.findElement(this.monitors).click();
    }

    public void clickOnProductWithName(String productName) {

        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='card-block']//a[.='" + productName + "']")));
        element.click();
    }
}
