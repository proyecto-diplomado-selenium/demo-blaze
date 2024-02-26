package Pagesp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProjectPage extends MainPage {

    public ProjectPage(WebDriver driver) {
        super(driver);
    }


    private final By userName = By.cssSelector("div.cu-simple-bar__top span");

    public String getUserName (){
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(this.userName));
        return element.getText();
    }

    private String getTextUserWorksSpaceName(){
        return driver.findElement(this.userName).getText();
    }

}
