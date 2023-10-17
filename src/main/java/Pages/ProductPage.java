package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage extends BasePage{
    private final By productName = By.xpath("//h2[@class='name']");
    private final By addToCartBtn = By.xpath("//a[normalize-space()='Add to cart']");

    public ProductPage(WebDriver driver) {
        super(driver);
    }
    public void clickOnAddToCart() {
        driver.findElement(this.addToCartBtn).click();
    }

    public String getProductTitleName (){
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(this.productName));
        return element.getText();
    }

    public String getAlertText(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public void acceptAlert(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
