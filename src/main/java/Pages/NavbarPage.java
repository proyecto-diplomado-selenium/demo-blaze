package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavbarPage extends BasePage{
    private final By home = By.xpath("//a[contains(.,'Home')]");
    private final By contact = By.xpath("//a[contains(.,'Contact')]");
    private final By aboutUs = By.xpath("//a[contains(.,'About us')]");
    private final By cart = By.xpath("//a[contains(.,'Cart')]");
    private final By login = By.xpath("//a[contains(.,'Log in')]");
    private final By signup = By.xpath("//a[contains(.,'Sign up')]");
    private final By logout = By.id("logout2");
    private final By signedUser = By.id("nameofuser");

    public NavbarPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnHomeOption() {
        driver.findElement(this.home).click();
    }

    public void clickOnContactOption() {
        driver.findElement(this.contact).click();
    }

    public void  clickOnAboutUsOption() {
        driver.findElement(this.aboutUs).click();
    }

    public void clickOnCartOption() {
        driver.findElement(this.cart).click();
    }

    public void clickOnLoginOption() {
        driver.findElement(this.login).click();
    }

    public void clickOnSignupOption() {
        driver.findElement(this.signup).click();
    }

    public String getNameUserOfUser() {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(this.signedUser));
        return element.getText();
    }
}
