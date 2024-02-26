package Pagesp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {

    protected WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@class='CuNavigation_contactGroup__WpPNb navigation__auth']/a")
    private WebElement LoginButton;
}
