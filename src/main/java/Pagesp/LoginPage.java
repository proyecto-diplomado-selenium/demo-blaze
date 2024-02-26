package Pagesp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends MainPage {

    private final By username = By.id("login-email-input");
    private final By password = By.id("login-password-input");
    private final By loginBtn = By.cssSelector("button[type='submit']");
//    private final By errorMessage = By.xpath("//a[@class='cu-form__error-text']");
    private final By errorMessage = By.xpath("//span[@class='cu-form__error-text']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        driver.findElement(this.username).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(this.password).sendKeys(password);
    }
    public void clicKOnPassword() {
        driver.findElement(this.password).click();
    }

    public void clickOnLoginButton() {
        driver.findElement(loginBtn).click();
    }


    public void login(String username,String password){
        enterUsername(username);
        enterPassword(password);
        clickOnLoginButton();
    }

    public String getErrorMessage(){
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOf(driver.findElement(errorMessage)));

        return element.getText();
    }
}
