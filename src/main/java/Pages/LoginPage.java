package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By username = By.id("loginusername");
    private final By password = By.id("loginpassword");
    private final By closeBtn = By.xpath("//div[@id='exampleModal']//button[normalize-space()='Close']");
    private final By loginBtn = By.xpath("//button[normalize-space()='Log in']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        driver.findElement(this.username).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(this.password).sendKeys(password);
    }

    public void clickOnLoginButton() {
        driver.findElement(loginBtn).click();
    }

    public void clickOnCloseButton() {
        driver.findElement(closeBtn).click();
    }

    public void login(String username,String password){
        enterUsername(username);
        enterPassword(password);
        clickOnLoginButton();
    }

}
