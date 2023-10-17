package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends BasePage{
    private final By placeOrderBtn = By.xpath("//button[@data-toggle=\"modal\"]");
    private final By totalPrice = By.id("totalp");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnPlaceOrderButton() {
        driver.findElement(this.placeOrderBtn).click();
    }

    public String getTotal() {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(this.totalPrice));
        return element.getText();
    }

    public void deleteProductFromCartWithName(String productName) {
        driver.findElement(By.xpath("//td[text()='"+productName+"']/following-sibling::td/a")).click();
    }
}
